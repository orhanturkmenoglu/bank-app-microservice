package com.example.accounts.consumer;

import com.example.accounts.dto.CustomerDto;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

/*
@Component
public class KafkaConsumer {

    @KafkaListener(topics = "customer-create",groupId = "myGroup")
    public void consume(CustomerDto customerDto){
        System.out.println("RECEIVED MESSAGE:"+customerDto.toString());
    }
}
*/
