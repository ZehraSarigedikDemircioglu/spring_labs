package com.cydeo.service.impl;

import com.cydeo.model.Cart;
import com.cydeo.model.CartItem;
import com.cydeo.model.Product;
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
        Product product = productService.findProductById(productId);

        //todo initialise cart item
        CartItem cartItem = new CartItem();
        //todo calculate cart total amount
        cartItem.setQuantity(quantity);
        cartItem.setProduct(product);
        cartItem.setTotalAmount(product.getPrice().multiply(BigDecimal.valueOf(quantity)));
        //todo add to cart
        CART.getCartItemList().add(cartItem);
        //todo update cart
        CART.setCartTotalAmount(CART.getCartTotalAmount().add(cartItem.getTotalAmount()));
        return CART;
    }

    @Override
    public boolean deleteFromCart(UUID productId){
        CartItem itemToDelete = CART.getCartItemList().stream()
                .filter(cartItem -> cartItem.getProduct().getId().equals(productId))
                .findAny().orElseThrow();

        CART.setCartTotalAmount(CART.getCartTotalAmount().subtract(itemToDelete.getTotalAmount()));
        //todo delete product object from cart using stream

        return CART.getCartItemList().remove(itemToDelete);
    }
}
