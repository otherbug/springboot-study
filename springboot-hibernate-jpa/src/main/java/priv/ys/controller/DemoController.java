package priv.ys.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import priv.ys.bean.Demo;
import priv.ys.service.DemoService;

import javax.annotation.Resource;

@RestController
@RequestMapping("/demo")
public class DemoController {
    @Resource
    private DemoService demoService;

    @RequestMapping("/save")
    public String save(){
        Demo demo=new Demo();
        demo.setName("殷爽");
        demoService.save(demo);
        return "ok.DemoController.save";
    }

}
