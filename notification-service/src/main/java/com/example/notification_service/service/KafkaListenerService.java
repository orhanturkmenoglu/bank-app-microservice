package com.example.notification_service.service;

import com.example.notification_service.model.CustomerDto;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Component;

@Component
public class KafkaListenerService {

    private final MailService mailService;

    @Autowired
    public KafkaListenerService(MailService mailService) {
        this.mailService = mailService;
    }

    @KafkaListener(topics = "customer-create", groupId = "notification-service")
    public void listenAndSendMail(CustomerDto customerDto) {
        System.out.println("Received message: " + customerDto.toString());
        // Kafka mesajını aldıktan sonra mail gönder
        String to = customerDto.getEmail();
        String subject = "Customer Creation Confirmation";
        String body = "Dear " + customerDto.getName() + ",\n\nYour account has been successfully created.";

        mailService.sendMail(to, subject, body);
    }
}