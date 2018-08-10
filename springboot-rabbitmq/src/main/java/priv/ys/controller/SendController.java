package priv.ys.controller;

import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

@RestController
public class SendController {
    @Autowired
    private AmqpTemplate amqpTemplate;

    @RequestMapping("/send")
    public String send() {
        String content = "Date:" + new Date();
        amqpTemplate.convertAndSend("hello", content);
        return content;
    }

    @RequestMapping("/multiSend")
    public String multiSend() {
        StringBuffer times = new StringBuffer();
        for (int i = 01; i <= 10; i++) {
            long time = System.nanoTime();
            amqpTemplate.convertAndSend("hello", " 第" + i + "次发送的时间为：" + time);
            times.append(time + "<br>");
        }
        return times.toString();
    }

    @RequestMapping("/multi2MultiSend")
    public String multi2MultiSend() {
        StringBuffer times = new StringBuffer();
        for (int i = 1; i <= 10; i++) {
            long time = System.nanoTime();
            amqpTemplate.convertAndSend("hello", " 第" + i + "次发送的时间为：" + time);
            amqpTemplate.convertAndSend("world", " 第" + i + "次发送的时间为：" + time);
            times.append(time + "<br>");
        }
        return times.toString();
    }

    @RequestMapping("/topicSend1")
    public String topicSend1(){
        String context="my topic 1";
        System.out.println("发送者说："+context);
        this.amqpTemplate.convertAndSend("exchange","topic.message",context);
        return context;
    }

    @RequestMapping("/topicSend2")
    public String topic2(){
        String context="my topic 2";
        System.out.println("发送者说: "+context);
        this.amqpTemplate.convertAndSend("exchange","topic.messages",context);
        return context;
    }
}
