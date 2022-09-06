package com.tr.springboot.transaction.service;

public interface TransactionService1 {

    void m();

    void t();

    void tInvokeInnerM();

    void tInvokeOutM();

    void mInvokeInnerT();

    void mInvokeOutT();

    void tInvokeInnerT();

    void tInvokeOutT();

}
