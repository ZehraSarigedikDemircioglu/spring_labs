package com.cydeo.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Login {
    private String email;
    private String phoneNumber;
    private String password;

    public Login(String email, String phoneNumber) {
        this.email = email;
        this.phoneNumber = phoneNumber;
    }
}
