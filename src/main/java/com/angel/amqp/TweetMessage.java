package com.angel.amqp;

import lombok.Data;

import java.io.Serializable;

@Data
public class TweetMessage implements Serializable {

    private String title;
    private String body;

}
