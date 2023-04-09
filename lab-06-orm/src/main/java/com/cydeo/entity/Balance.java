package com.cydeo.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import javax.persistence.*;
import java.math.BigDecimal;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Balance extends BaseEntity{
    private BigDecimal amount;
    @OneToOne // unidirection
    private Customer customer;

}
