package com.bankapi.bank_transfer_api.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransferResponse {
    // Getters and setters
    private final String message;
    private final String sourceAccountNumber;
    private final double sourceBalance;
    private final String destinationAccountNumber;
    private final double destinationBalance;

    public TransferResponse(String message, String sourceAccountNumber, double sourceBalance,
                            String destinationAccountNumber, double destinationBalance) {
        this.message = message;
        this.sourceAccountNumber = sourceAccountNumber;
        this.sourceBalance = sourceBalance;
        this.destinationAccountNumber = destinationAccountNumber;
        this.destinationBalance = destinationBalance;
    }

}
