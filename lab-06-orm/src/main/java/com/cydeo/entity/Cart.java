package com.cydeo.entity;

import com.cydeo.enums.CartState;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;

@Entity
@NoArgsConstructor
@Data

public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Enumerated(EnumType.STRING)
    private CartState cartState;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Discount discount;
}
