package org.example.cards.service.client;

import org.example.cards.dto.CustomerDetailsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient("accounts")
public interface CustomerFeignClient {

    @GetMapping("api/fetchCustomerDetails")
    ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam String mobileNumber);
}
