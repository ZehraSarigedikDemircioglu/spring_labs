package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.Cart;
import com.cydeo.lab07ormqueries.enums.CartState;
import com.cydeo.lab07ormqueries.enums.DiscountType;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartRepository extends JpaRepository<Cart, Long> {

    //Write a derived query to get all cart by specific discount type
    List<Cart> findAllByDiscountDiscountType(DiscountType discountType);

    //Write a JPQL query to get all cart by customer
    @Query("select c from Cart c WHERE c.customer.id = ?1")
    List<Cart> retrieveCartListByCustomer(Long id);

    //Write a derived query to get all cart by customer and cart state
    List<Cart> findAllByCustomerIdAndCartState(Long id, CartState cartState);

    //Write a derived query to get all cart by customer and cart state and discount is null condition

    //Write a native query to get all cart by customer and cart state and discount is not null condition
}
