package com.banking.balance.service.impl;

import com.banking.balance.model.Transaction;
import com.banking.balance.service.BalanceService;
import com.banking.balance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class BalanceServiceImpl implements BalanceService {

    @Autowired
    private TransactionService transactionService;

    @Override
    public Map<String, Double> getMonthlyBalance() {
        List<Transaction> transactions = transactionService.getTransactions();
        return transactions.stream()
                .collect(Collectors.groupingBy(
                        transaction -> transaction.getDate().substring(0, 6), // Extract year and month from yyyymmdd
                        Collectors.summingDouble(Transaction::getAmount) // Sum amounts for the same month
                ));
    }

    @Override
    public Double getCumulativeBalance() {
        double cumulativeBalance = 0.0;
        List<Transaction> transactions = transactionService.getTransactions();

        for (Transaction transaction : transactions) {
            cumulativeBalance += transaction.getAmount();
        }

        return cumulativeBalance;
    }
}
