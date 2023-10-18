package com.banking.balance.controller;

import com.banking.balance.service.BalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

@RestController("/balance")
public class BalanceController {
    @Autowired
    private BalanceService balanceService;

    @GetMapping("/monthly")
    public ResponseEntity<Map<String, Double>> getMonthlyBalances() {
        Map<String, Double> monthlyBalances = balanceService.getMonthlyBalance();
        return ResponseEntity.ok(monthlyBalances);
    }

    @GetMapping("/cumulative")
    public ResponseEntity<Double> getCumulativeBalance() {
        double cumulativeBalance = balanceService.getCumulativeBalance();
        return ResponseEntity.ok(cumulativeBalance);
    }
}
