package com.cydeo.controller;

import com.cydeo.service.CartService;
import com.cydeo.service.ProductService;
import com.cydeo.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.UUID;


@Controller
public class CartController {

    private final CartService cartService;
    private final ProductService productService;

    public CartController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/cart")
    public String getCart(Model model) {
        model.addAttribute("cartList", CartServiceImpl.CART.getCartItemList());
        return "cart/show-cart";
    }

    @GetMapping("/addToCart/{id}/{quantity}")
    public String addToCart(@PathVariable UUID id, @PathVariable Integer quantity, Model model) {

        cartService.addToCart(id, quantity);

        return "product/list";
    }

    @GetMapping("/addToCart/{id}")
    public String deleteFromCart(@PathVariable UUID id, Model model) {
        cartService.deleteFromCart(id);

        return "cart/show-cart";
    }

}
