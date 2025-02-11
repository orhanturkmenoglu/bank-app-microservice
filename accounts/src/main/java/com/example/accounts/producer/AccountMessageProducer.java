package com.example.accounts.producer;

import com.example.accounts.dto.CustomerDto;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

import java.util.logging.Logger;

@Component
public class AccountMessageProducer {

    private static final Logger LOGGER = Logger.getLogger(AccountMessageProducer.class.getName());
    private final KafkaTemplate<String, Object> kafkaTemplate;

    @Value("${kafka.topic}")
    private String topic;

    public AccountMessageProducer(KafkaTemplate<String, Object> kafkaTemplate) {
        this.kafkaTemplate = kafkaTemplate;
    }


    public void sendMessage(CustomerDto customerDto) {
        LOGGER.info("Sending message to CustomerDTO: " + customerDto.toString());
        kafkaTemplate.send(topic, customerDto);
    }
}
