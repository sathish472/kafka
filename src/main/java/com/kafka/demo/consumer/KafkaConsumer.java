package com.kafka.demo.consumer;

import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
public class KafkaConsumer {

    @KafkaListener(topics = "TestTopic1", groupId = "G1")
    public void consumer(String message){
        System.out.println("Message Received: "+message);

    }
}

