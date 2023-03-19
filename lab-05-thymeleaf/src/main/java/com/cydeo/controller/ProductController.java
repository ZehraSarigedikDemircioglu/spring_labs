package com.cydeo.controller;

import com.cydeo.model.Product;
import com.cydeo.service.CartService;
import com.cydeo.service.ProductService;
import com.cydeo.service.impl.CartServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class ProductController {

    private final CartService cartService;
    private final ProductService productService;

    public ProductController(CartService cartService, ProductService productService) {
        this.cartService = cartService;
        this.productService = productService;
    }

    @GetMapping("/create-product")
    public String createProduct(Model model) {
        model.addAttribute("product", new Product());
        return "product/create-product";
    }

    @GetMapping("/create-form")
    public String createForm(Model model) {
        return "product/create-product";
    }

    @GetMapping("/list")
    public String getCart(Model model) {
        model.addAttribute("productList", productService.listProduct());
        return "product/list";
    }
}
