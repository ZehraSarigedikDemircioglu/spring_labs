package com.cydeo.controller;

import com.cydeo.model.Profile;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import java.time.LocalDateTime;

@Controller
public class ProfileController {
    @RequestMapping("/profile")
    public String getProfile(Model model) {

        LocalDateTime dt = LocalDateTime.now();

        Profile profile = new Profile("msmith@gmail.com", "+1256342345", "mike", "smith", "msmith", dt);
        model.addAttribute("profile", profile);

        return "profile/info";
    }
}
