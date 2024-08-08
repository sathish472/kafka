package com.kafka.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.support.SendResult;
import org.springframework.stereotype.Service;

import java.util.concurrent.CompletableFuture;

@Service
public class KafkaMessagePublisherService {

    @Autowired
    private KafkaTemplate<String, Object> kafkaTemplate;


    public void sendMessage(String message){
        CompletableFuture<SendResult<String, Object>> future = kafkaTemplate.send("TestTopic1", message);
        future.whenComplete((result, ex)->{
           if(ex==null){
               System.out.println("\n offset is "+result.getRecordMetadata().offset());
           }else{
               System.out.println("\n Exception "+ex.getMessage());
           }
        });
    }
}
