package com.bankapi.bank_transfer_api.service.impl;

import com.bankapi.bank_transfer_api.model.Account;
import com.bankapi.bank_transfer_api.service.AccountService;
import org.springframework.stereotype.Service;

import jakarta.annotation.PostConstruct;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Service
public class AccountServiceImpl implements AccountService {
    private final Map<String, Account> accountDatabase = new HashMap<>();

    @Override
    public Optional<Account> getAccount(String accountNumber) {
        return Optional.ofNullable(accountDatabase.get(accountNumber)); // Returns Optional<Account>
    }

    @Override
    public void updateAccount(Account account) {
        accountDatabase.put(account.getAccountNumber(), account);
    }

    // Initialize mock accounts when the service starts
    @PostConstruct
    public void init() {
        addMockAccounts();
    }

    // mock accounts
    public void addMockAccounts() {
        accountDatabase.put("12345", new Account("12345", 10000.00));
        accountDatabase.put("67890", new Account("67890", 15000.00));
    }
}

