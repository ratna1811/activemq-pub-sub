package com.learning.activemq_pub_sub.model;

import java.io.Serializable;

public class Message implements Serializable {
    private final String message;

    public Message(String message) {
        this.message = message;
    }

    public String getMessage() {
        return message;
    }

}
