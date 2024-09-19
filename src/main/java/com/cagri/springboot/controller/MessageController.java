package com.cagri.springboot.controller;

import com.cagri.springboot.publisher.RabbitMQProducer;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class MessageController {

    private RabbitMQProducer publisher;

    public MessageController(RabbitMQProducer publisher) {
        this.publisher = publisher;
    }

    @GetMapping("/publish")
    ResponseEntity<String> sendMessage(@RequestParam("message") String message){
        publisher.sendMessage(message);
        return ResponseEntity.ok("Message sent to RabbitMQ");
    }
}
