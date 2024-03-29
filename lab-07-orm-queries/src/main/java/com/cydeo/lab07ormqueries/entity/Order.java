package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import java.math.BigDecimal;


@Entity
@NoArgsConstructor
@Getter
@Setter
@Table(name = "orders")
@ToString
public class Order extends BaseEntity {
    private BigDecimal paidPrice;
    private BigDecimal totalPrice;
    @ManyToOne
    private Customer customer;
    @OneToOne
    private Cart cart;
    @OneToOne
    private Payment payment;

}
