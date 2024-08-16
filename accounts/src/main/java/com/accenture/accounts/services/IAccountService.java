package com.accenture.accounts.services;

import com.accenture.accounts.dto.AccountDto;
import com.accenture.accounts.dto.AccountWithCustomers;
import com.accenture.accounts.dto.NewAccountDto;

import java.util.List;

public interface IAccountService {

    AccountWithCustomers fetchAccountWithCustomersByAccountNumber(Long accountNumber);
    AccountDto create(NewAccountDto accountDto);

    AccountDto fetch(Long accountNumber);

    List<AccountDto> fetchCustomerAccounts(Long customerId);

    AccountDto update(AccountDto accountDto);

}
