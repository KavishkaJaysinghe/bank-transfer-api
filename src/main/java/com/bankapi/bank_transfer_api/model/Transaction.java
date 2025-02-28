package com.bankapi.bank_transfer_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Transaction {
    private String sourceAccountNumber;
    private String destinationAccountNumber;
    private double amount;
}

