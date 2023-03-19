package com.cydeo.service.impl;

import com.cydeo.model.Cart;
import com.cydeo.service.CartService;
import com.cydeo.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.UUID;
@Service
public class CartServiceImpl implements CartService {

    public static Cart CART = new Cart(BigDecimal.ZERO,new ArrayList<>());

    private final ProductService productService;

    public CartServiceImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public Cart addToCart(UUID productId, Integer quantity){
        //todo retrieve product from repository method

        //todo initialise cart item
        //todo calculate cart total amount
        //todo add to cart

        productService.listProduct();
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        //todo delete product object from cart using stream
        CART.getCartItemList().stream().map(p -> p.getProduct().getId().equals(productId)).findAny().orElseThrow();
        return true;
    }
}
