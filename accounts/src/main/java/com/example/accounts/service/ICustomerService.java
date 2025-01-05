package com.example.accounts.service;

import com.example.accounts.dto.CustomerDetailsDto;

public interface ICustomerService {

    /**
     *
     * @param mobileNumber - Input mobile number
     * @return CustomerDetailsDto object
     */
    CustomerDetailsDto fetchCustomerDetails(String mobileNumber);

}
