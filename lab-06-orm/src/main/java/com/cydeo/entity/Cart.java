package com.cydeo.entity;

import com.cydeo.enums.CartState;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Cart extends BaseEntity{

    @Enumerated(EnumType.STRING)
    private CartState cartState;
    @ManyToOne
    private Customer customer;
    @ManyToOne
    private Discount discount;

}
