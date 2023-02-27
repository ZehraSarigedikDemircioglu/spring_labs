package com.cydeo.loosely;

import java.math.BigDecimal;
import java.util.UUID;

public class XxxBalance extends Balance{

    public XxxBalance(UUID userId, BigDecimal amount) {
        super(userId, amount);
    }

    @Override
    public BigDecimal addBalance(BigDecimal amount) {
        return null;
    }
}
