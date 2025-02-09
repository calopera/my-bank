package com.accenture.customers.mapper;

import com.accenture.customers.dto.CustomerDto;
import com.accenture.customers.dto.CustomerWithAccounts;
import com.accenture.customers.entity.Customer;

public class CustomerMapper {

    public static CustomerDto mapCustomerToDto(Customer customer, CustomerDto customerDto){
        customerDto.setAddress(customer.getAddress());
        customerDto.setDocument(customer.getDocument());
        customerDto.setName(customer.getName());
        customerDto.setPhone(customer.getPhone());
        customerDto.setEmail(customer.getEmail());

        return customerDto;
    }
    public static CustomerWithAccounts mapCustomerToDtoWithAccounts(Customer customer, CustomerWithAccounts customerDtoWithAccounts) {
        customerDtoWithAccounts.setAddress(customer.getAddress());
        customerDtoWithAccounts.setName(customer.getName());
        customerDtoWithAccounts.setPhone(customer.getPhone());
        customerDtoWithAccounts.setEmail(customer.getEmail());
        customerDtoWithAccounts.setDocument(customer.getDocument());

        return customerDtoWithAccounts;
    }

    public static Customer mapDtoToCustomer(CustomerDto customerDto, Customer customer) {
        customer.setAddress(customerDto.getAddress());
        customer.setName(customerDto.getName());
        customer.setPhone(customerDto.getPhone());
        customer.setEmail(customerDto.getEmail());
        customer.setDocument(customerDto.getDocument());

        return customer;
    }

}
