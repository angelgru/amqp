package com.angel.amqp;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Data
@Component
@ConfigurationProperties(prefix = "rabbit")
public class MyProperties {

    private String twitterExchange;
    private String twitterQueue;
    private String routingKey;
}
