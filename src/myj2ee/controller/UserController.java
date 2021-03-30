package myj2ee.controller;

import myj2ee.bean.User;
import myj2ee.dao.UserDao;
import myj2ee.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserService userService;

    @RequestMapping("/login")
    public String login(@RequestParam("username")String username,
                        @RequestParam("password")String password,
                        HttpServletRequest request){
        System.out.println("login");
        User user = userService.login(username, password);
        if(user == null){
            request.setAttribute("msg", "用户名不存在");
            return "forward:index.jsp";
        }else if(user.getPassword() == null){
            request.setAttribute("msg", "密码错误");
            return "forward:index.jsp";
        }

        request.getSession().setAttribute("user", user);
        return "user/user";
    }


    @RequestMapping("/logout")
    public String logout(HttpServletRequest request){
        System.out.println("logout");
        request.getSession().setAttribute("user", null);
        return "redirect:index.jsp";
    }

    @RequestMapping("/userManage")
    public String userManager(HttpServletRequest request){
        System.out.println("userManager");
        User loginUser = (User) request.getSession().getAttribute("user");
        if(loginUser == null || !loginUser.isAdmin()){
            return "redirect:index.jsp";
        }

        List<User> users = userDao.getAllUser();
        request.setAttribute("users", users);
        for(User user: users){
            System.out.println(user);
        }
        return "manage/userManage";
    }

    @RequestMapping("/addUser")
    public String addUser(@RequestParam("username") String username,
                          @RequestParam("password") String password,
                          HttpServletRequest request){
        System.out.println("addUser");
        User loginUser = (User) request.getSession().getAttribute("user");
        if(loginUser == null || !loginUser.isAdmin()){
            return "redirect:index.jsp";
        }
        int state = userService.addUser(new User(null, username, password, false));
        System.out.println(state);
        return "redirect:/userManage";
    }

    @RequestMapping("/deleteUser")
    public String deleteUser(@RequestParam("id") Integer id,
                             HttpServletRequest request){
        System.out.println("deleteUser");
        User loginUser = (User) request.getSession().getAttribute("user");
        if(loginUser == null || !loginUser.isAdmin()){
            return "redirect:index.jsp";
        }
        int state = userService.deleteUser(id);
        System.out.println(state);
        return "redirect:/userManage";
    }
}
