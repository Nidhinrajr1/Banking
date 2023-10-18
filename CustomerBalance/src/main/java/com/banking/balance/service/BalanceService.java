package com.banking.balance.service;

import java.util.Map;

public interface BalanceService {
    Map<String, Double> getMonthlyBalance();

    Double getCumulativeBalance();
}
