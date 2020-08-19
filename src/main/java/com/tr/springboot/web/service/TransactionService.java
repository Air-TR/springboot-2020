package com.tr.springboot.web.service;

public interface TransactionService {

    void beforeTransactionUpdate();

    void afterTransactionUpdate();

    void transactionUpdate();
}
