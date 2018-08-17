package priv.ys.controller;

import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
//@RequestMapping("/users")
//@PreAuthorize("hasRole('USER')")//有ROLE_USER权限的可以访问
public class HomeController {

    @PreAuthorize("hasRole('USER')")//有ROLE_USER权限的可以访问
    @RequestMapping(value = "/admin/test1")
    @ResponseBody
    public String adminTest1(){
        return "ROLE_USER";
    }

    @PreAuthorize("hasRole('ADMIN')")//有ROLE_USER权限的可以访问
    @RequestMapping(value = "/admin/test2")
    @ResponseBody
    public String adminTest2(){
        return "ROLE_ADMIN";
    }
//
//    @RequestMapping("/login")
//    public String login(){
//        return "/index1";
//    }

    @RequestMapping("/main/login")
    public String mainlogin(){
        return "login";
    }
}
