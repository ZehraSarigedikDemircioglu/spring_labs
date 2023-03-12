package com.cydeo.controller;


import com.cydeo.service.ProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
@AllArgsConstructor
public class ProductController {

    ProductService productService;

    @RequestMapping("/search-product/{productName}")
    public String searchProduct(@PathVariable String productName, Model model) {

        model.addAttribute("productList", productService.searchProduct(productName));

        return "product/list";

    }
}
