package com.banking.balance.service.impl;

import com.banking.balance.model.Transaction;
import com.banking.balance.service.TransactionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import java.util.Arrays;
import java.util.List;
import java.util.Objects;

@Service
public class TransactionServiceImpl implements TransactionService {

    @Value("${api.url}")
    private String apiUrl;
    @Autowired
    private RestTemplate restTemplate;

    @Override
    public List<Transaction> getTransactions() {
        ResponseEntity<Transaction[]> response = restTemplate.getForEntity(apiUrl, Transaction[].class);
        return Arrays.asList(Objects.requireNonNull(response.getBody()));
    }
}
