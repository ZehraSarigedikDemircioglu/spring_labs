package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.CartItem;
import com.cydeo.lab07ormqueries.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //Write a derived query to get count cart items

    Integer countCartItemBy();

    //Write a derived query to get cart items for specific cart state
    List<CartItem> findAllByCart_CartState(CartState cartState);

    //Write a native query to get cart items for specific cart state and product name
    //Write a native query to get cart items for specific cart state and without discount
    //Write a native query to get cart items for specific cart state and with specific Discount type
}
