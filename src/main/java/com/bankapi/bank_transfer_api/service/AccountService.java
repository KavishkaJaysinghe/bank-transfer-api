package com.bankapi.bank_transfer_api.service;

import java.util.Optional;
import com.bankapi.bank_transfer_api.model.Account;

public interface AccountService {
    public Optional<Account> getAccount(String accountNumber);
    void updateAccount(Account account);
}