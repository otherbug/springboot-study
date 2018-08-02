package priv.ys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.ys.bean.Demo;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @RequestMapping("/getDemo")
    public Demo getDemo(){
        Demo demo=new Demo(5,"例子");
        return demo;
    }

    @RequestMapping("/zeroException")
    public int zeroException(){
        return 100/0;
    }
}
