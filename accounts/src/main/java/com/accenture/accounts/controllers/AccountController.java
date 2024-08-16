package com.accenture.accounts.controllers;

import com.accenture.accounts.dto.*;
import com.accenture.accounts.services.IAccountService;
import com.accenture.accounts.services.ITransactionsService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.Size;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping(path = "/api")
public class AccountController {
    @NonNull
    private final IAccountService accountService;
    @NonNull
    private final ITransactionsService transactionsService;
    @NonNull
    private Environment environment;
    @NonNull
    private SupportInfoDto supportInfoDto;
    @GetMapping(value = "/java-home")
    public ResponseEntity<String> javaVerion() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(environment.getProperty("JAVA_HOME"));
    }

    @GetMapping(value = "/support-info")
    public ResponseEntity<SupportInfoDto> supportInfo() {
        return ResponseEntity
                .status(HttpStatus.OK)
                .body(supportInfoDto);
    }
    @PostMapping(value = "/createAccount", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> createAccount(@RequestBody NewAccountDto accountDto) {
        AccountDto savedAccount = accountService.create(accountDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(savedAccount);
    }

    @GetMapping(value = "/fetchAccount/{accountNumber}")
    public ResponseEntity<AccountDto> fetchAccount(@PathVariable Long accountNumber) {

        AccountDto accountDto = accountService.fetch(accountNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accountDto);
    }

    @GetMapping(value = "/fetchCustomerAccounts/{customerId}")
    public ResponseEntity<List<AccountDto>> fetchCustomerAccounts(@PathVariable Long customerId) {

        List<AccountDto> accounts = accountService.fetchCustomerAccounts(customerId);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(accounts);
    }

    @PostMapping(value = "/createTransaction")
    public ResponseEntity<ResponseDto> createTransaction(@RequestBody NewTransactionsDto transactionsDto) {

        transactionsService.create(transactionsDto);

        return ResponseEntity
                .status(HttpStatus.CREATED)
                .body(new ResponseDto("201", "Transaccion creada correctamente !!"));
    }

    @PutMapping(value = "/updateByDocument", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountDto> updateByDocument(@Valid @RequestBody AccountDto accountDto) {
        AccountDto updated = accountService.update(accountDto);
        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(updated);
    }

    @GetMapping(value = "/fetchTransactions/{accountNumber}")
    public ResponseEntity<List<TransactionsDto>> fetchTransactions(@PathVariable Long accountNumber) {

        List<TransactionsDto> transactionsDtos = transactionsService.fetchAccountTransactions(accountNumber);

        return ResponseEntity
                .status(HttpStatus.OK)
                .body(transactionsDtos);
    }

    @GetMapping(value = "/fetchAccountWithCustomer", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<AccountWithCustomers> fetchWithAccounts(
            @RequestParam Long accountNumber) {

        AccountWithCustomers accountWithCustomer = accountService.fetchAccountWithCustomersByAccountNumber(accountNumber);

        return  ResponseEntity
                .status(HttpStatus.OK)
                .body(accountWithCustomer);
    }

}
