package com.tr.springboot.service;

public interface TransactionService {

    void beforeTransactionUpdate();

    void afterTransactionUpdate();

    void transactionUpdate();
}
