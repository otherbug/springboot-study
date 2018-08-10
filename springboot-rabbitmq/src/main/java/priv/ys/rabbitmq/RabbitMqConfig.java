package priv.ys.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;


/*
队列配置
 */
@Configuration
public class RabbitMqConfig {

    //一对一 或者一对多
    @Bean
    public Queue hello() {
        return new Queue("hello");
    }

    //多对多
    @Bean
    public Queue world(){
        return new Queue("world");
    }
}
