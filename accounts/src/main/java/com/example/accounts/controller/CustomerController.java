package com.example.accounts.controller;

import com.example.accounts.dto.CustomerDetailsDto;
import com.example.accounts.service.ICustomerService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.validation.constraints.Pattern;
import lombok.RequiredArgsConstructor;
import org.apache.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping(path = "/api",produces = {MediaType.APPLICATION_JSON_VALUE})
@Validated
@Tag(name = " REST API for Customer in Bank application"
        ,description = " REST APIs in Bank application to FETCH customer details")
@RequiredArgsConstructor
public class CustomerController {

    private final ICustomerService customerService;

    @Operation(
            summary = "Fetch Customer Details REST API",
            description = "REST API to fetch Customer details based on a mobile number"
    )
    @ApiResponse(
            responseCode = "200",
            description = "HTTP Status 200 OK"
    )
    @GetMapping("/fetchCustomerDetails")
    public ResponseEntity<CustomerDetailsDto> fetchCustomerDetails(@RequestParam
                                                                   @Pattern(regexp ="(^$|[0-9]{10})", message = "Mobile number should be 10 digits" )
                                                                   String mobileNumber) {
         return ResponseEntity.status(HttpStatus.SC_OK).body(customerService.fetchCustomerDetails(mobileNumber));
    }
}
