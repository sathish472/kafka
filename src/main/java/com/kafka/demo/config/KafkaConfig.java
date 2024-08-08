package com.kafka.demo.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class KafkaConfig {

    @Bean
    public NewTopic createTopic(){
        NewTopic newTopic = new NewTopic("TestTopic1", 5,(short)1);
        System.out.println("\n Topic created.");
        return  newTopic;
    }
}
