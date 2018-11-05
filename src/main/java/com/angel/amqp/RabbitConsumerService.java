package com.angel.amqp;

import lombok.extern.slf4j.Slf4j;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class RabbitConsumerService {

    private final MyProperties myProperties;

    @Autowired
    public RabbitConsumerService(MyProperties myProperties) {
        this.myProperties = myProperties;
    }

    @RabbitListener(queues = "twitter-queue")
    public void receive(TweetMessage message) {
        log.error("Rabbit Consumer received a message " + message.getBody());
    }
}
