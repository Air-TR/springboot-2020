package com.tr.springboot.web.service;

public interface AccountService {

    void transfer();

    void resetData();

    void transferAccounts(int fromAccountId, int toAccountId, Double account);

}
