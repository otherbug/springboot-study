package priv.ys.controller;

import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

@Controller
public class HomeController {

    @RequestMapping({"/","/index"})
    public String index() {
        return "/index";
    }

    @RequestMapping("/login")
    public String login(HttpServletRequest request, Map<String, Object> map)  throws Exception{
        System.out.println("HomeContoller.....");

        //登录失败从request中获取shiro处理的异常信息
        //shiroLoginFailure：就是Shiro异常类的全类名
        String exception = (String) request.getAttribute("shiroLoginFailure");

        System.out.println("异常：" + exception);
        String msg = "";
        if (exception!=null){
            if (UnknownAccountException.class.getName().equals(exception)){
                System.out.println("UnknownAccountException------账号不存在");
                msg="UnknownAccountException账号不存在！";
            }else if (IncorrectCredentialsException.class.getName().equals(exception)){
                System.out.println("IncorrectCredentialsException---------密码不正确");
                msg="IncorrectCredentialsException密码不正确！";
            }else if ("kaptchaValidateFailed ".equals(exception)){
                System.out.println("kaptchaValidateFailed 验证码不正确");
                msg="kaptchaValidateFailed 验证码不正确！";
            }else {
                msg="else >>" +exception;
                System.out.println("esle>> "+exception);
            }
        }

        map.put("msg",msg);
        //此方法不处理登陆成功，由Shiro进行处理
        return "/login";
    }
}
