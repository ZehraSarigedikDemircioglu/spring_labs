package com.cydeo.lab07ormqueries.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import java.math.BigDecimal;
import java.util.List;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Product extends BaseEntity{

    private String name;
    private BigDecimal price;
    private Integer quantity;
    private Integer remainingQuantity;

    @JoinTable(name = "product_category_rel",
            joinColumns = @JoinColumn(name = "p_id"), inverseJoinColumns = @JoinColumn(name = "c_id"))
    @ManyToMany
    private List<Category> categoryList;
}
