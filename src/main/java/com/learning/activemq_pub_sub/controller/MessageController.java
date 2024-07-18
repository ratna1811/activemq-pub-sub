package com.learning.activemq_pub_sub.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.learning.activemq_pub_sub.model.Message;
import com.learning.activemq_pub_sub.publisher.MessagePublisher;

@RestController
@RequestMapping("/topic")
public class MessageController {
    private final MessagePublisher messagePublisher;

    public MessageController(MessagePublisher messagePublisher) {
        this.messagePublisher = messagePublisher;
    }

    @PostMapping("/publishMessage")
    public ResponseEntity<String> publishMessage(@RequestBody String message) {
        Message publishedMessage = new Message(message);
        try {
            messagePublisher.publishMessage(publishedMessage);
            return new ResponseEntity<>("Message Published Successfully!", HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>("Error publishing message", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
}
