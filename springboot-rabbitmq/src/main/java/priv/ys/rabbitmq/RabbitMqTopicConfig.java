package priv.ys.rabbitmq;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMqTopicConfig {
    //只接一个topic
    final static String message = "topic.message";
    final static String messages = "topic.messages";

    @Bean
    public Queue queueMessage() {
        return new Queue(RabbitMqTopicConfig.message);
    }

    @Bean
    public Queue queueMessages() {
        return new Queue(RabbitMqTopicConfig.messages);
    }

    @Bean
    public TopicExchange exchange(){
        return new TopicExchange("exchange");
    }

    @Bean
    public  Binding bindingExchangeMessage(Queue queueMessage,TopicExchange exchange){
        return BindingBuilder.bind(queueMessage).to(exchange).with("topic.message");
    }

    @Bean
    public Binding bindingExchangeMessages(Queue queueMessages,TopicExchange exchange){
        //#表示零个或者多个
        return BindingBuilder.bind(queueMessages).to(exchange).with("topic.#");
    }
}
