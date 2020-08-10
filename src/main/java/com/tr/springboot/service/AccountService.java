package com.tr.springboot.service;

import java.math.BigDecimal;

public interface AccountService {

    void transfer();

    void resetData();

    void transferAccounts(int fromAccountId, int toAccountId, BigDecimal account);

}
