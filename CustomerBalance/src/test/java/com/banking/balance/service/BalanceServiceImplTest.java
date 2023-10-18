package com.banking.balance.service;

import com.banking.balance.model.Transaction;
import com.banking.balance.service.impl.BalanceServiceImpl;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class BalanceServiceImplTest {

    @Mock
    private TransactionService transactionService;

    @InjectMocks
    private BalanceServiceImpl balanceService;

    @BeforeEach
    public void setup() {
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void testGetMonthlyBalance() {
        List<Transaction> mockTransactions = Arrays.asList(
                new Transaction("20220115", 100.0),
                new Transaction("20220220", 150.0),
                new Transaction("20220225", 75.0)
        );

        // Mock the behavior of the TransactionService
        Mockito.when(transactionService.getTransactions()).thenReturn(mockTransactions);

        // Act
        Map<String, Double> monthlyBalances = balanceService.getMonthlyBalance();

        // Assert
        assertEquals(2, monthlyBalances.size());
        assertEquals(100.0, monthlyBalances.get("202201"));
        assertEquals(225.0, monthlyBalances.get("202202"));
    }

    @Test
    public void testGetCumulativeBalance() {
        List<Transaction> mockTransactions = Arrays.asList(
                new Transaction("20220115", 100.0),
                new Transaction("20220220", 150.0),
                new Transaction("20220225", 75.0)
        );

        // Mock the behavior of the TransactionService
        Mockito.when(transactionService.getTransactions()).thenReturn(mockTransactions);

        // Act
        Double cumulativeBalance = balanceService.getCumulativeBalance();

        // Assert
        assertEquals(325.0, cumulativeBalance);
    }
}
