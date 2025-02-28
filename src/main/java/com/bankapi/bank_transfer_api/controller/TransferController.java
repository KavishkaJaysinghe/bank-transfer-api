package com.bankapi.bank_transfer_api.controller;

import com.bankapi.bank_transfer_api.dto.TransferRequestDTO;
import com.bankapi.bank_transfer_api.dto.TransferResponse;
import com.bankapi.bank_transfer_api.exception.AccountNotFoundException;
import com.bankapi.bank_transfer_api.exception.InsufficientFundsException;
import com.bankapi.bank_transfer_api.model.Transaction;
import com.bankapi.bank_transfer_api.service.TransferService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import jakarta.validation.Valid;

@CrossOrigin(value = "*")
@RestController
@RequestMapping("/api/transfers")
public class TransferController {

    private final TransferService transferService;

    public TransferController(TransferService transferService) {
        this.transferService = transferService;
    }

    @PostMapping
    public ResponseEntity<TransferResponse> transferFunds(@Valid @RequestBody TransferRequestDTO transferRequest) {
        Transaction transaction = new Transaction(
                transferRequest.getSourceAccountNumber(),
                transferRequest.getDestinationAccountNumber(),
                transferRequest.getAmount()
        );

        TransferResponse response = transferService.transferFunds(transaction);
        return ResponseEntity.ok(response);
    }

    @ExceptionHandler(AccountNotFoundException.class)
    public ResponseEntity<String> handleAccountNotFoundException(AccountNotFoundException ex) {
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ex.getMessage());
    }

    @ExceptionHandler(InsufficientFundsException.class)
    public ResponseEntity<String> handleInsufficientFundsException(InsufficientFundsException ex) {
        return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(ex.getMessage());
    }
}

