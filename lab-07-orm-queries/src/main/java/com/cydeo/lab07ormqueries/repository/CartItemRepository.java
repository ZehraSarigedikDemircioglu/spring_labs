package com.cydeo.lab07ormqueries.repository;

import com.cydeo.lab07ormqueries.entity.CartItem;
import com.cydeo.lab07ormqueries.enums.CartState;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CartItemRepository extends JpaRepository<CartItem, Long> {

    //Write a derived query to get count cart items

    Integer countCartItemBy();

    //Write a derived query to get cart items for specific cart state
    List<CartItem> findAllByCart_CartState(CartState cartState);

    //Write a native query to get cart items for specific cart state and product name
    @Query(value = "select * from cart_item cijoin c on ci.cart_id = c.id join p on ci.product_id =p.id where c.cart_state =?1", nativeQuery = true)
    List<CartItem> retrieveAllCartItemByCartStateAndProductName(@Param("cartState") String cartState, @Param("name") String name);

    //Write a native query to get cart items for specific cart state and without discount
    @Query(value = "select * from cart_item ci join cart c on  ci.cart_id = c.id where c.cart_state=?1 and c.discount_id is null", nativeQuery=true)
    List<CartItem> retrieveCartItemsByCartStateWithoutDiscount(@Param("cartState") String cartState);

    //Write a native query to get cart items for specific cart state and with specific Discount type
    @Query(value="SELECT * FROM cart_item ci JOIN cart c ON  ci.cart_id=c.id JOIN discount d ON c.discount_id =d.id " +
            "WHERE c.cart_state=?1 AND d.discount_type = ?2", nativeQuery = true)
    List<CartItem> retrieveCartItemsByCartStateAndDiscountType(@Param("cartState") String cartState, @Param("discountType") String discountType);
}
