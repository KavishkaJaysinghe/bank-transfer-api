package com.bankapi.bank_transfer_api.service;

import com.bankapi.bank_transfer_api.dto.TransferResponse;
import com.bankapi.bank_transfer_api.model.Transaction;

public interface TransferService {
    TransferResponse transferFunds(Transaction transaction);
}
