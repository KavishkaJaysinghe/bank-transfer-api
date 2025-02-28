package com.bankapi.bank_transfer_api.dto;

import lombok.Getter;
import lombok.Setter;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;

@Getter
@Setter
public class TransferRequestDTO {

    @NotNull
    private String sourceAccountNumber;

    @NotNull
    private String destinationAccountNumber;

    @Positive
    private double amount;

    public TransferRequestDTO(String sourceAccountNumber, String destinationAccountNumber, double amount) {
        this.sourceAccountNumber = sourceAccountNumber;
        this.destinationAccountNumber = destinationAccountNumber;
        this.amount = amount;
    }

    private TransferRequestDTO() {
    }

    public static TransferRequestDTO createTransferRequestDTO() {
        return new TransferRequestDTO();
    }
}

