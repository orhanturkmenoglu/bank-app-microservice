package com.example.accounts.service.client;

import com.example.accounts.dto.CardsDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

// open feign client : rest template'dir http yöntemleri ile microservisler arasında iletişm sağlar.
@FeignClient("cards")
public interface CardsFeingClient {

    @GetMapping(value = "/api/fetch",consumes = "application/json")
    ResponseEntity<CardsDto> fetchCardDetails(@RequestParam String mobileNumber);
}
