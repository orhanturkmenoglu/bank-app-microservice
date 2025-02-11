package com.example.notification_service.model;

public class CustomerDto {
    private String name;
    private String email;

    private String mobileNumber;

    private AccountsDto accountsDto;

    public CustomerDto() {
    }

    public CustomerDto(String name, String email, String mobileNumber, AccountsDto accountsDto) {
        this.name = name;
        this.email = email;
        this.mobileNumber = mobileNumber;
        this.accountsDto = accountsDto;
    }


    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    public void setMobileNumber(String mobileNumber) {
        this.mobileNumber = mobileNumber;
    }

    public AccountsDto getAccountsDto() {
        return accountsDto;
    }

    public void setAccountsDto(AccountsDto accountsDto) {
        this.accountsDto = accountsDto;
    }

    @Override
    public String toString() {
        return "CustomerDto{" +
                "name='" + name + '\'' +
                ", email='" + email + '\'' +
                ", mobileNumber='" + mobileNumber + '\'' +
                ", accountsDto=" + accountsDto +
                '}';
    }
}
