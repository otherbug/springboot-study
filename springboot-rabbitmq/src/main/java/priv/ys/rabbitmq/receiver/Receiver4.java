package priv.ys.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "world")
public class Receiver4 {
    @RabbitHandler
    public void receiver(String msg){
        System.out.println("Test2 receiver4:"+msg);
    }
}
