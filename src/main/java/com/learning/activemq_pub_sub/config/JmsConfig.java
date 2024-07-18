package com.learning.activemq_pub_sub.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jms.annotation.EnableJms;
import org.springframework.jms.config.DefaultJmsListenerContainerFactory;
import org.springframework.jms.config.JmsListenerContainerFactory;
import org.springframework.jms.core.JmsTemplate;

import jakarta.jms.ConnectionFactory;

@Configuration
@EnableJms // to ensure that necessary support for Jms is enabled,this class becomes the
           // dedicated configuration class for all the jms related beans
public class JmsConfig {
    // method that finds a bean named topicListnerFactory, this returns a
    // JmsListenerContainerFactory configured for topics.
    // we need a DefaultJmsListenerContainerFactory to create a listnerContainer
    // ConnectionFactory - Jms connection factory
    @Bean
    public JmsListenerContainerFactory<?> topicListenerFactory(ConnectionFactory connectionFactory) {
        DefaultJmsListenerContainerFactory factory = new DefaultJmsListenerContainerFactory();
        // sets the JmsConnectionFactory for this
        // DefaultJmsListenerContainerFactory Factory
        factory.setConnectionFactory(connectionFactory);
        // setting this true enables topic mode for this container indicating that it
        // will listen messages from topics
        factory.setPubSubDomain(true);
        return factory;
    }

    // It defines the JmsTemplate configured for the topic
    @Bean
    JmsTemplate jmsTopicTemplate(ConnectionFactory connectionFactory) {
        JmsTemplate jmsTemplate = new JmsTemplate(connectionFactory);
        jmsTemplate.setPubSubDomain(true);// indicating that this is intended for topic based messaging
        return jmsTemplate;
    }
}
