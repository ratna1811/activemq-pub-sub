package com.learning.activemq_pub_sub.publisher;

import org.springframework.jms.core.JmsTemplate;
import org.springframework.stereotype.Component;

import com.learning.activemq_pub_sub.model.Message;

@Component
public class MessagePublisher {
    private final JmsTemplate jmsTemplate;

    public MessagePublisher(JmsTemplate jmsTemplate) {
        this.jmsTemplate = jmsTemplate;
    }

    public void publishMessage(Message message) {
        jmsTemplate.convertAndSend("Topic.Learning", message);
    }
}
