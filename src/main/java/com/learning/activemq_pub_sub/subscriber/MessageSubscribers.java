package com.learning.activemq_pub_sub.subscriber;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.jms.annotation.JmsListener;
import org.springframework.stereotype.Component;

import com.learning.activemq_pub_sub.model.Message;

@Component
public class MessageSubscribers {

    private static final Logger LOGGER = LoggerFactory.getLogger(MessageSubscribers.class);

    // here we are indicating the user the listening container configured for topics
    // in JmsConfig class
    @JmsListener(destination = "Topic.Learning", containerFactory = "topicListenerFactory")
    public void receiveMessage(Message message) {
        LOGGER.info("Message Received Successfully by Subscriber 1:" + message.getMessage());
    }

    @JmsListener(destination = "Topic.Learning", containerFactory = "topicListenerFactory")
    public void receiveMessage2(Message message) {
        LOGGER.info("Message Received Successfully by Subscriber 2:" + message.getMessage());
    }

    @JmsListener(destination = "Topic.Learning", containerFactory = "topicListenerFactory")
    public void receiveMessage3(Message message) {
        LOGGER.info("Message Received Successfully by Subscriber 3:" + message.getMessage());
    }

}
