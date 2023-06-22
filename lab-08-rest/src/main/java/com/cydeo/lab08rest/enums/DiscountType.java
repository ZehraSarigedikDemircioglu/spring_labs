package com.cydeo.lab08rest.enums;

public enum DiscountType {
    AMOUNT_BASED, RATE_BASED

    // assume amount based => $50 if $500 minimum. So, for example $600 purchase, then $50 discount => $550

    // assume rate based => $300 minimum, and %20 discount. So, for example $600 purchase, then %20 discount => $480
}
