package com.cydeo.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.math.BigInteger;
import java.util.List;

@Entity
@NoArgsConstructor
@Data
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String email;
    private String firstName;
    private String lastName;
    private String userName;

    @OneToOne
    private Balance balance;
    @OneToMany
    private List<Orders> ordersList;
    @OneToMany
    private List<Cart> cartList;
    @OneToMany
    private List<Address> addressList;

    public Customer(String email, String firstName, String lastName, String userName) {
        this.email = email;
        this.firstName = firstName;
        this.lastName = lastName;
        this.userName = userName;
    }
}
