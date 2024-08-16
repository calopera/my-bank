package com.accenture.customers.service;

import com.accenture.customers.dto.CustomerDto;
import com.accenture.customers.dto.CustomerWithAccounts;

public interface ICustomerService {

    CustomerWithAccounts fetchCustomerWithAccountsByDocument(String document);

    void createCustomer(CustomerDto customerDto);

    CustomerDto fetchCustomerByDocument(String document);

    CustomerDto fetchCustomerByEmail(String email);

    CustomerDto updateCustomer(CustomerDto customerDto);

    void deleteByDocument(String document);
    CustomerDto findById(Long customerId);
}
