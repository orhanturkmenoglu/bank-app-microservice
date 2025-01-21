package com.example.accounts.service.impl;

import com.example.accounts.dto.CardsDto;
import com.example.accounts.dto.CustomerDetailsDto;
import com.example.accounts.dto.LoansDto;
import com.example.accounts.entity.Accounts;
import com.example.accounts.entity.Customer;
import com.example.accounts.exception.ResourceNotFoundException;
import com.example.accounts.mapper.AccountsMapper;
import com.example.accounts.mapper.CustomerMapper;
import com.example.accounts.repository.AccountsRepository;
import com.example.accounts.repository.CustomerRepository;
import com.example.accounts.service.ICustomerService;
import com.example.accounts.service.client.CardsFeignClient;
import com.example.accounts.service.client.LoansFeignClient;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CustomerServiceImpl implements ICustomerService {

    private final AccountsRepository accountsRepository;

    private final CustomerRepository customerRepository;

    private final CardsFeignClient cardsFeignClient;

    private final LoansFeignClient loansFeignClient;

    /**
     * @param mobileNumber - Input mobile number
     * @return CustomerDetailsDto object
     */
    @Override
    public CustomerDetailsDto fetchCustomerDetails(String mobileNumber) {
        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account", "Customer Id",
                                customer.getCustomerId().toString()));

        CustomerDetailsDto customerDetailsDto = CustomerMapper.mapToCustomerDetailsDto(customer);
        customerDetailsDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts));


        //cards service ile open feign client ile istek atıyoruz iletişime geçiyoruz
        //loans service ile open feign client ile istek atıyoruz iletişime geçiyoruz

        ResponseEntity<LoansDto> loansDtoResponseEntity =
                loansFeignClient.fetchLoanDetails(mobileNumber);

        if (null != loansDtoResponseEntity) {
            customerDetailsDto.setLoansDto(loansDtoResponseEntity.getBody());
        }

        ResponseEntity<CardsDto> cardsDtoResponseEntity =
                cardsFeignClient.fetchCardDetails(mobileNumber);

        if (null != cardsDtoResponseEntity) {
            customerDetailsDto.setCardsDto(cardsDtoResponseEntity.getBody());
        }

        return customerDetailsDto;
    }
}
