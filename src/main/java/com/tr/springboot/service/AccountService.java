package com.tr.springboot.service;

import java.math.BigDecimal;

public interface AccountService {

    void transferAccounts(int fromAccountId, int toAccountId, BigDecimal account);

}
