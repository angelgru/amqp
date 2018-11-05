package com.angel.amqp;

import org.springframework.amqp.core.*;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitMQConfiguration {

    final MyProperties myProperties;

    @Autowired
    public RabbitMQConfiguration(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    @Bean
    public Queue queue() {
        return new Queue(myProperties.getTwitterQueue());
    }

    @Bean
    public TopicExchange exchange() {
        return new TopicExchange(myProperties.getTwitterExchange());
    }

    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(myProperties.getRoutingKey());
    }

    @Bean
    public MessageConverter jsonMessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
