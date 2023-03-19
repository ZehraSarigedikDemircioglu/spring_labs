package com.cydeo.controller;

import com.cydeo.service.CartService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.UUID;

import static com.cydeo.service.impl.CartServiceImpl.CART;


@Controller
public class CartController {
    private final CartService cartService;

    public CartController(CartService cartService) {
        this.cartService = cartService;
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cart", CART);
        return "cart/show-cart";
    }

    @GetMapping("/addToCart/{id}/{quantity}")
    public String addToCart(@PathVariable("id") UUID id, @PathVariable("quantity") Integer quantity) {

        cartService.addToCart(id, quantity);

        return "redirect:/cart";
    }

    @GetMapping("/delete/{id}")
    public String deleteFromCart(@PathVariable UUID id) {
        cartService.deleteFromCart(id);

        return "redirect:/cart";
    }

}
