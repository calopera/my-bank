package com.accenture.accounts.services.client;

import com.accenture.accounts.dto.CustomerDto;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;


@FeignClient("customers")
public interface AccountFeignClient {
    @GetMapping(value = "/api/fetchAccountById/{customerId}", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<CustomerDto> fetchAccountById(@PathVariable Long customerId);
}