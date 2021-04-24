package myj2ee.controller;

import com.google.gson.Gson;
import myj2ee.bean.User;
import myj2ee.dao.UserDao;
import myj2ee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    private Hashtable<String, User> loginUsers = new Hashtable<String, User>();

    @ResponseBody
    @RequestMapping(value = "/login", method = RequestMethod.POST)
    public String login(@RequestBody Map<String, String> map, HttpServletRequest request){
        System.out.println("login");

        String username = map.get("username");
        String password = map.get("password");
        System.out.println(password);
        String type = map.get("type");


        User user = userService.login(username, password);
        System.out.println(user);
        Map<String, Object> respbody = new HashMap<String, Object>();
        Gson gson = new Gson();
        if(user == null){
            respbody.put("isError", 1);
            respbody.put("msg", "username not exists");
            return gson.toJson(respbody);

        }else if(user.getPassword() == null){
            respbody.put("isError", 1);
            respbody.put("msg", "wrong password");
            return gson.toJson(respbody);
        }else if(user.isAdmin() != type.equals("admin")){
            respbody.put("isError", 1);
            respbody.put("msg", "wrong type");
            return gson.toJson(respbody);
        }

        loginUsers.put(username, user);
        respbody.put("isError", 0);

        return gson.toJson(respbody);
    }

    @ResponseBody
    @RequestMapping("/logout")
    public String logout(@RequestBody Map<String, String> map, HttpServletRequest request){
        System.out.println("logout");
        if(loginUsers.keySet().contains(map.get("loginUser"))){
            loginUsers.remove(map.get("loginUser"));
        }

        return "";
    }

    @ResponseBody
    @RequestMapping("/userManage")
    public String userManager(@RequestBody Map<String, String> map, HttpServletRequest request){
        System.out.println("userManager");
        User loginUser = loginUsers.get(map.get("loginUser"));
        Map<String, Object> respbody = new HashMap<String, Object>();
        Gson gson = new Gson();
        if(loginUser == null || !loginUser.isAdmin()){
            respbody.put("isErr", 1);
            respbody.put("msg", "无管理员权限");
            return gson.toJson(respbody);
        }

        List<User> users = userDao.getAllUser();
        respbody.put("isErr", 0);
        respbody.put("users", users);
        for(User user: users){
            System.out.println(user);
        }
        return gson.toJson(respbody);
    }

    @ResponseBody
    @RequestMapping("/addUser")
    public String addUser(@RequestBody Map<String, String> map, HttpServletRequest request){
        System.out.println("addUser");

        String username = map.get("username");
        String password = map.get("password");

        User loginUser = loginUsers.get(map.get("loginUser"));
        Map<String, Object> respbody = new HashMap<String, Object>();
        Gson gson = new Gson();

        if(loginUser == null || !loginUser.isAdmin()){
            respbody.put("isErr", 1);
            respbody.put("msg", "无管理员权限");
            return gson.toJson(respbody);
        }

        int state = userService.addUser(new User(null, username, password, false));
        System.out.println(state);
        respbody.put("isErr", 0);

        return gson.toJson(respbody);

    }

    @ResponseBody
    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestBody Map<String, String> map,HttpServletRequest request){
        System.out.println("deleteUser");

        int id = Integer.parseInt(map.get("id"));

        User loginUser = loginUsers.get(map.get("loginUser"));
        Map<String, Object> respbody = new HashMap<String, Object>();
        Gson gson = new Gson();
        if(loginUser == null || !loginUser.isAdmin()){
            respbody.put("isErr", 1);
            respbody.put("msg", "无管理员权限");
            return gson.toJson(respbody);
        }else if(id == loginUser.getId()){
            respbody.put("isErr", 1);
            respbody.put("msg", "不能删除自己");
            return gson.toJson(respbody);
        }

        int state = userService.deleteUser(id);
        System.out.println(state);
        respbody.put("isErr", 0);

        return gson.toJson(respbody);
    }
}
