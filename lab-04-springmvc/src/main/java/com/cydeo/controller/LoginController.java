package com.cydeo.controller;

import com.cydeo.model.Login;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class LoginController {
    @RequestMapping("/login/{email}/{phoneNumber}")
    public String getLogin(@PathVariable String email, @PathVariable String phoneNumber, Model model) {

        Login login = new Login("email@email.com", "1234124241");

        model.addAttribute("email", login.getEmail());
        model.addAttribute("phoneNumber", login.getPhoneNumber());
        model.addAttribute("loginMessage", "Login successful");

        return "login/info";
    }


}
