package com.bankapi.bank_transfer_api.service.impl;

import com.bankapi.bank_transfer_api.dto.TransferResponse;
import com.bankapi.bank_transfer_api.exception.AccountNotFoundException;
import com.bankapi.bank_transfer_api.exception.InsufficientFundsException;
import com.bankapi.bank_transfer_api.model.Account;
import com.bankapi.bank_transfer_api.model.Transaction;
import com.bankapi.bank_transfer_api.service.AccountService;
import com.bankapi.bank_transfer_api.service.TransferService;
import org.springframework.stereotype.Service;

@Service
public class TransferServiceImpl implements TransferService {

    private final AccountService accountService;

    // Constructor Injection
    public TransferServiceImpl(AccountService accountService) {
        this.accountService = accountService;
    }

    @Override
    public TransferResponse transferFunds(Transaction transaction) {
        Account sourceAccount = accountService.getAccount(transaction.getSourceAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("Source account not found: " + transaction.getSourceAccountNumber()));

        Account destinationAccount = accountService.getAccount(transaction.getDestinationAccountNumber())
                .orElseThrow(() -> new AccountNotFoundException("Destination account not found: " + transaction.getDestinationAccountNumber()));

        if (sourceAccount.getBalance() < transaction.getAmount()) {
            throw new InsufficientFundsException("Insufficient funds");
        }

        // Perform the transfer
        sourceAccount.setBalance(sourceAccount.getBalance() - transaction.getAmount());
        destinationAccount.setBalance(destinationAccount.getBalance() + transaction.getAmount());

        // Update accounts
        accountService.updateAccount(sourceAccount);
        accountService.updateAccount(destinationAccount);

        // Return a response, balances
        return new TransferResponse("Transfer successful",
                sourceAccount.getAccountNumber(), sourceAccount.getBalance(),
                destinationAccount.getAccountNumber(), destinationAccount.getBalance());
    }

}
