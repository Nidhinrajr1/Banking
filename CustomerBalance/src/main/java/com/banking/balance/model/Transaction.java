package com.banking.balance.model;


import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Transaction {

    private String date;
    private Double amount;
}
