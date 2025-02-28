package com.bankapi.bank_transfer_api.controller;

import com.bankapi.bank_transfer_api.dto.TransferRequestDTO;
import com.bankapi.bank_transfer_api.dto.TransferResponse;
import com.bankapi.bank_transfer_api.exception.AccountNotFoundException;
import com.bankapi.bank_transfer_api.exception.InsufficientFundsException;
import com.bankapi.bank_transfer_api.model.Transaction;
import com.bankapi.bank_transfer_api.service.TransferService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.http.ResponseEntity;

import java.util.Objects;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

@ExtendWith(MockitoExtension.class)
class TransferControllerTest {

    @Mock
    private TransferService transferService;

    @InjectMocks
    private TransferController transferController;

    private TransferRequestDTO transferRequest;
    private TransferResponse transferResponse;
    private Transaction transaction;

    @BeforeEach
    void setUp() {
        transferRequest = new TransferRequestDTO("123456", "654321", 100.0);
        transferResponse = new TransferResponse("Success", "123456", 500.0, "654321", 600.0);
        transaction = new Transaction("123456", "654321", 100.0);
    }

    @Test
    void transferFunds_Success() {
        when(transferService.transferFunds(any(Transaction.class))).thenReturn(transferResponse);

        ResponseEntity<TransferResponse> response = transferController.transferFunds(transferRequest);

        assertNotNull(response);
        assertEquals(200, response.getStatusCodeValue());
        assertEquals("Success", Objects.requireNonNull(response.getBody()).getMessage());
    }

    @Test
    void transferFunds_AccountNotFoundException() {
        when(transferService.transferFunds(any(Transaction.class)))
                .thenThrow(new AccountNotFoundException("Account not found"));

        AccountNotFoundException exception = assertThrows(AccountNotFoundException.class, () -> transferController.transferFunds(transferRequest));

        assertNotNull(exception);
        assertEquals("Account not found", exception.getMessage());
    }

    @Test
    void transferFunds_InsufficientFundsException() {
        when(transferService.transferFunds(any(Transaction.class)))
                .thenThrow(new InsufficientFundsException("Insufficient funds"));

        InsufficientFundsException exception = assertThrows(InsufficientFundsException.class, () -> {
            transferController.transferFunds(transferRequest);
        });

        assertEquals("Insufficient funds", exception.getMessage());
    }
}
