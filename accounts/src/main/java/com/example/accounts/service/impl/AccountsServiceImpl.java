package com.example.accounts.service.impl;

import com.example.accounts.constants.AccountConstants;
import com.example.accounts.dto.AccountsDto;
import com.example.accounts.dto.CustomerDto;
import com.example.accounts.entity.Accounts;
import com.example.accounts.entity.Customer;
import com.example.accounts.exception.CustomerAlreadyExistException;
import com.example.accounts.exception.ResourceNotFoundException;
import com.example.accounts.mapper.AccountsMapper;
import com.example.accounts.mapper.CustomerMapper;
import com.example.accounts.producer.AccountMessageProducer;
import com.example.accounts.repository.AccountsRepository;
import com.example.accounts.repository.CustomerRepository;
import com.example.accounts.service.IAccountsService;
import org.springframework.stereotype.Service;

import java.util.Optional;
import java.util.Random;

@Service
public class AccountsServiceImpl implements IAccountsService {

    private final AccountsRepository accountsRepository;
    private final CustomerRepository customerRepository;

    private final AccountMessageProducer accountMessageProducer;

    public AccountsServiceImpl(AccountsRepository accountsRepository, CustomerRepository customerRepository, AccountMessageProducer accountMessageProducer) {
        this.accountsRepository = accountsRepository;
        this.customerRepository = customerRepository;
        this.accountMessageProducer = accountMessageProducer;
    }

    @Override
    public void createAccount(CustomerDto customerDto) {

        Customer customer = CustomerMapper.mapToCustomer(customerDto);
        Optional<Customer> optionalCustomer = customerRepository.findByMobileNumber(customerDto.getMobileNumber());

        if (optionalCustomer.isPresent()) {
            throw new CustomerAlreadyExistException("Customer already registered with given mobile number"
                    + customerDto.getMobileNumber());
        }

        // müşteri oluştuğunda kullanıcıya hesap bilgilerini  email ile eşzamanlı bildirim gönder.

        Customer savedCustomer = customerRepository.save(customer);
        Accounts savedAccounts = accountsRepository.save(createNewAccount(savedCustomer));

        CustomerDto savedCustomerDto = CustomerMapper.mapToCustomerDto(savedCustomer);
        savedCustomerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(savedAccounts));

        accountMessageProducer.sendMessage(savedCustomerDto);


    }


    private Accounts createNewAccount(Customer customer) {
        Accounts newAccount = new Accounts();
        newAccount.setCustomerId(customer.getCustomerId());
        long randomAccNumber = 1000000000L + new Random().nextInt(900000000);

        newAccount.setAccountNumber(randomAccNumber);
        newAccount.setAccountType(AccountConstants.SAVINGS);
        newAccount.setBranchAddress(AccountConstants.ADDRESS);
        return newAccount;
    }

    @Override
    public CustomerDto fetchAccount(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() -> new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber));

        Accounts accounts = accountsRepository.findByCustomerId(customer.getCustomerId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Account", "Customer Id",
                                customer.getCustomerId().toString()));

        CustomerDto customerDto = CustomerMapper.mapToCustomerDto(customer);
        customerDto.setAccountsDto(AccountsMapper.mapToAccountsDto(accounts));
        return customerDto;
    }

    @Override
    public boolean updateAccount(CustomerDto customerDto) {
        AccountsDto accountsDto = customerDto.getAccountsDto();
        boolean isUpdated = false;
        if (accountsDto != null) {
            Accounts accounts = accountsRepository.findById(accountsDto.getAccountNumber())
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Account", "Account Number", accountsDto.getAccountNumber().toString()));

            AccountsMapper.mapToAccounts(accountsDto);
            accounts = accountsRepository.save(accounts);

            Long customerId = accounts.getCustomerId();
            Customer customer = customerRepository.findById(customerId)
                    .orElseThrow(() ->
                            new ResourceNotFoundException("Customer", "Customer Id", customerId.toString()));

            CustomerMapper.mapToCustomer(customerDto);
            customerRepository.save(customer);
            isUpdated = true;
        }
        return isUpdated;
    }

    @Override
    public boolean deleteAccount(String mobileNumber) {

        Customer customer = customerRepository.findByMobileNumber(mobileNumber)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Customer", "Mobile Number", mobileNumber));

        accountsRepository.deleteByCustomerId(customer.getCustomerId());
        customerRepository.deleteById(customer.getCustomerId());
        return true;
    }


}
