package myj2ee.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class common {

    @RequestMapping("/home")
    public String home(){
        return "../../index.jsp";
    }
}
