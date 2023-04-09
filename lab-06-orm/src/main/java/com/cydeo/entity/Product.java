package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;
    @OneToMany
    private List<CartItem> cartItemList;

    public Product(BigDecimal price, Integer quantity, Integer remainingQuantity) {
        this.price = price;
        this.quantity = quantity;
        this.remainingQuantity = remainingQuantity;
    }
}
