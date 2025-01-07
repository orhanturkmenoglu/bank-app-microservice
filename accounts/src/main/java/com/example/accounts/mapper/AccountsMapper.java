package com.example.accounts.mapper;

import com.example.accounts.dto.AccountsDto;
import com.example.accounts.entity.Accounts;

public class AccountsMapper {

    // AccountsDto'dan Accounts'a dönüşüm
    private static void mapFromDtoToEntity(AccountsDto accountsDto, Accounts accounts) {
        accounts.setAccountNumber(accountsDto.getAccountNumber());
        accounts.setAccountType(accountsDto.getAccountType());
        accounts.setBranchAddress(accountsDto.getBranchAddress());
    }

    // Accounts'dan AccountsDto'ya dönüşüm
    private static void mapFromEntityToDto(Accounts accounts, AccountsDto accountsDto) {
        accountsDto.setAccountNumber(accounts.getAccountNumber());
        accountsDto.setAccountType(accounts.getAccountType());
        accountsDto.setBranchAddress(accounts.getBranchAddress());
    }

    public static AccountsDto mapToAccountsDto(Accounts accounts) {
        AccountsDto accountsDto = new AccountsDto();
        mapFromEntityToDto(accounts, accountsDto);
        return accountsDto;
    }

    public static Accounts mapToAccounts(AccountsDto accountsDto) {
        Accounts accounts = new Accounts();
        mapFromDtoToEntity(accountsDto, accounts);
        return accounts;
    }


}
