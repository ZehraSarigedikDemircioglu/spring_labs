package com.cydeo.lab07ormqueries.entity;


import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
@NoArgsConstructor
@Getter
@Setter
public class Address extends BaseEntity {
    private String name;
    private String street;
    private String zipCode;
    @ManyToOne
    private Customer customer;
}
