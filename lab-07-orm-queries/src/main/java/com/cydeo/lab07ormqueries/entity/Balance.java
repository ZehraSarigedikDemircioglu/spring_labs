package com.cydeo.lab07ormqueries.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToOne;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Balance extends BaseEntity{
    private BigDecimal amount;
    @OneToOne(fetch = FetchType.LAZY) // unidirection
    private Customer customer;

}
