package com.eszsz.concept_tester.controller;

import com.eszsz.concept_tester.service.KafkaProducerService;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/messages")
public class MessageController {

    private final KafkaProducerService producerService;
    private final String topic;

    public MessageController(KafkaProducerService producerService,
                             @Value("${app.kafka.topic}") String topic) {
        this.producerService = producerService;
        this.topic = topic;
    }

    @PostMapping
    public String sendMessage(@RequestParam String message) {
        producerService.sendMessage(topic, message);
        return "Message sent: " + message;
    }
}
