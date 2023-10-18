package com.banking.balance.service;

import com.banking.balance.model.Transaction;

import java.util.List;

public interface TransactionService {
    List<Transaction> getTransactions();
}
