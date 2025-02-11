package com.example.accounts.mapper;

import com.example.accounts.dto.CustomerDetailsDto;
import com.example.accounts.dto.CustomerDto;
import com.example.accounts.entity.Customer;

public class CustomerMapper {

    // Common fields mapping for both CustomerDto and CustomerDetailsDto
    private static <T> void mapCommonFields(Customer customer, T dto) {
        if (dto instanceof CustomerDto) {
            ((CustomerDto) dto).setName(customer.getName());
            ((CustomerDto) dto).setEmail(customer.getEmail());
            ((CustomerDto) dto).setMobileNumber(customer.getMobileNumber());
            ((CustomerDto) dto).setAccountsDto(((CustomerDto) dto).getAccountsDto());
        } else if (dto instanceof CustomerDetailsDto) {
            ((CustomerDetailsDto) dto).setName(customer.getName());
            ((CustomerDetailsDto) dto).setEmail(customer.getEmail());
            ((CustomerDetailsDto) dto).setMobileNumber(customer.getMobileNumber());

        }
    }

    public static CustomerDto mapToCustomerDto(Customer customer) {
        CustomerDto customerDto = new CustomerDto();
        mapCommonFields(customer, customerDto);
        return customerDto;
    }

    public static CustomerDetailsDto mapToCustomerDetailsDto(Customer customer) {
        CustomerDetailsDto customerDetailsDto = new CustomerDetailsDto();
        mapCommonFields(customer, customerDetailsDto);
        return customerDetailsDto;
    }

    public static Customer mapToCustomer(CustomerDto customerDto) {
        Customer customer = new Customer();
        customer.setName(customerDto.getName());
        customer.setEmail(customerDto.getEmail());
        customer.setMobileNumber(customerDto.getMobileNumber());
        return customer;
    }




}
