package priv.ys.controller;


import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/wx")
public class WeChatController {
    @GetMapping
    public String check(String signature,//	微信加密签名，结合了开发者填写的token参数和请求中的timestamp参数、nonce参数。
                        String timestamp,//时间戳
                        String nonce,//随机数
                        String echostr//	随机字符串
                        ){
        return null;
    }
    @PostMapping
    public void hjh(){

    }
}
