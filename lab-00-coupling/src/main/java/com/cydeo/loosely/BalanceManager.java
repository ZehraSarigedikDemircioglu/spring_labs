package com.cydeo.loosely;

import java.math.BigDecimal;

public class BalanceManager {

    public boolean checkout(BigDecimal checkoutAmount, Balance balance){

        return balance.getAmount().subtract(checkoutAmount)
                .compareTo(BigDecimal.ZERO) > 0;
    }
}
