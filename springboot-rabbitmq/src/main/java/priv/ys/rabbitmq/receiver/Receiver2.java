package priv.ys.rabbitmq.receiver;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
@RabbitListener(queues = "hello")
public class Receiver2 {

    @RabbitHandler
    public void receiver(String msg){
        System.out.println("Test1 receiver2: "+msg);
    }
}
