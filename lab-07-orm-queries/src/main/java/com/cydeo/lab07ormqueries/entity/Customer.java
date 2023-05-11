package com.cydeo.lab07ormqueries.entity;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.persistence.Entity;

@Entity
@NoArgsConstructor
@Getter
@Setter
@ToString
public class Customer extends BaseEntity{
    private String email;
    private String firstName;
    private String lastName;
    private String userName;

}
