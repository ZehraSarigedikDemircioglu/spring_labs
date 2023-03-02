package com.cydeo.controller;

import com.cydeo.service.CartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;

@Controller
public class CartController {
    @Autowired
    CartService cartService;

    @RequestMapping("/cart-list")
    public String getCart(Model model) {
        model.addAttribute("cartList", cartService.retrieveCartList());
        return "cart/list";
    }

    @RequestMapping("/cart-list/{id}")
    public String getCartItemList(@PathVariable String id, Model model) {
        model.addAttribute("cartItemList", cartService.retrieveCartDetail(UUID.fromString(id)));
        return "cart/detail";
    }


}
