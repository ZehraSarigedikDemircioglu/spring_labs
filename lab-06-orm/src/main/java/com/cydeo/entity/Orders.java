package com.cydeo.entity;

import lombok.Data;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;
import java.math.BigDecimal;


@Entity
@NoArgsConstructor
@Getter
@Setter
public class Orders extends BaseEntity{
    private BigDecimal paidPrice;
    private BigDecimal totalPrice;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Cart cart;
    @OneToOne
    private Payment payment;

}
