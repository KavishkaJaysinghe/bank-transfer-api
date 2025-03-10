package com.bankapi.bank_transfer_api.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@AllArgsConstructor
@ToString
public class Account {
    private final String accountNumber;
    @Setter
    private double balance;

}
