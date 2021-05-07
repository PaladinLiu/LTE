package myj2ee.controller;

import com.google.gson.Gson;
import myj2ee.bean.User;
import myj2ee.dao.UserDao;
import myj2ee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import sun.rmi.runtime.Log;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.Hashtable;
import java.util.List;
import java.util.Map;

@Controller
public class UserController {

//    @Autowired
//    private UserDao userDao;

    @Autowired
    private UserService userService;

    private Hashtable<String, User> loginUsers = new Hashtable<String, User>();

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public Map<String, Object> login(@RequestBody Map<String, String> map, HttpServletRequest request){
        System.out.println("login");

        String username = map.get("username");
        String password = map.get("password");
        String type = map.get("type");


        User user = userService.login(username, password);
        Map<String, Object> respbody = new HashMap<String, Object>();
        if(user == null){
            respbody.put("isError", 1);
            respbody.put("msg", "用户名不存在");
            return respbody;

        }else if(user.getPassword() == null){
            respbody.put("isError", 1);
            respbody.put("msg", "密码错误");
            return respbody;

        }else if(user.isAdmin() != type.equals("admin")){
            respbody.put("isError", 1);
            respbody.put("msg", "用户类型错误");
            return respbody;
        }

        loginUsers.put(username, user);
        respbody.put("isError", 0);

        return respbody;
    }

    @ResponseBody
    @RequestMapping(value = "/logout", method = RequestMethod.POST)
    public void logout(@RequestBody Map<String, String> map, HttpServletRequest request){
        System.out.println("logout");

        if(loginUsers.keySet().contains(map.get("loginUser"))){
            loginUsers.remove(map.get("loginUser"));
        }

    }

    @ResponseBody
    @RequestMapping(value = "/userManage", method = RequestMethod.POST)
    public Map<String, Object> userManager(@RequestBody Map<String, String> map, HttpServletRequest request){
        System.out.println("userManager");

        User loginUser = loginUsers.get(map.get("loginUser"));
        Map<String, Object> respbody = new HashMap<String, Object>();

        if(loginUser == null || !loginUser.isAdmin()){
            respbody.put("isError", 1);
            respbody.put("msg", "无管理员权限");
            return respbody;
        }

        List<User> users = userService.getAllUser();
        respbody.put("isError", 0);
        respbody.put("users", users);

        for(User user: users){
            System.out.println(user);
        }
        return respbody;
    }

    @ResponseBody
    @RequestMapping(value = "/addUser", method = RequestMethod.POST)
    public Map<String, Object> addUser(@RequestBody Map<String, String> map, HttpServletRequest request){
        System.out.println("addUser");

        String username = map.get("username");
        String password = map.get("password");

        User loginUser = loginUsers.get(map.get("loginUser"));
        Map<String, Object> respbody = new HashMap<String, Object>();

        if(loginUser == null || !loginUser.isAdmin()){
            respbody.put("isError", 1);
            respbody.put("msg", "无管理员权限");
            return respbody;
        }

        int state = userService.addUser(new User(null, username, password, false));
        System.out.println(state);
        respbody.put("isError", 0);

        return respbody;

    }

    @ResponseBody
    @RequestMapping(value = "/deleteUser", method = RequestMethod.POST)
    public Map<String, Object> deleteUser(@RequestBody Map<String, String> map,HttpServletRequest request){
        System.out.println("deleteUser");

        int id = Integer.parseInt(map.get("id"));

        User loginUser = loginUsers.get(map.get("loginUser"));
        Map<String, Object> respbody = new HashMap<String, Object>();
        Gson gson = new Gson();
        if(loginUser == null || !loginUser.isAdmin()){
            respbody.put("isError", 1);
            respbody.put("msg", "无管理员权限");
            return respbody;
        }else if(id == loginUser.getId()){
            respbody.put("isError", 1);
            respbody.put("msg", "不能删除自己");
            return respbody;
        }

        int state = userService.deleteUser(id);
        System.out.println(state);
        respbody.put("isError", 0);

        return respbody;
    }
}
