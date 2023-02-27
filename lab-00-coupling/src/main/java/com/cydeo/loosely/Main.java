package com.cydeo.loosely;


import java.math.BigDecimal;
import java.util.UUID;


public class Main {

    public static void main(String[] args) {
        UUID user = UUID.randomUUID();

        Balance customerBalance = new CustomerBalance(user, BigDecimal.ZERO);
        Balance giftCardBalance = new GiftCardBalance(user, BigDecimal.ZERO);

        customerBalance.addBalance(new BigDecimal(150));
        giftCardBalance.addBalance(new BigDecimal(120));

        BalanceManager balanceManager = new BalanceManager();

        System.out.println(balanceManager.checkout(new BigDecimal(160), customerBalance)); // FALSE
        System.out.println(balanceManager.checkout(new BigDecimal(80), giftCardBalance)); // TRUE
    }

}
