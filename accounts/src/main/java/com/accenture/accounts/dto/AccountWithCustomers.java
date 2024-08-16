package com.accenture.accounts.dto;

import lombok.Data;

import java.util.List;

@Data
public class AccountWithCustomers {
    List<AccountDto> accounts;
    private Long accountNumber;
    private Long customerId;
    private String accountType;
    private String branch;
    private Float balance;
    //private AccountDto cuenta;
    private CustomerDto customer;
}
