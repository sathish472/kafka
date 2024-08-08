package com.kafka.demo.controller;

import com.kafka.demo.service.KafkaMessagePublisherService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/producer")
public class KafkaController {

    @Autowired
    private KafkaMessagePublisherService kafkaMessagePublisherService;



    @GetMapping("/message")
    public String message(){
        return "Hello";
    }

    @GetMapping("/send/{message1}/{message2}")
    public ResponseEntity<String> sendMessage(@PathVariable String message1, @PathVariable String message2){
        kafkaMessagePublisherService.sendMessage(message1+message2);
        return ResponseEntity.ok("Message sent");
    }


}
