package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.dto.UpdateOrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrderByEmail(String email);

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderByPaymentMethod(PaymentMethod paymentMethod);

    OrderDTO updateOrderById(Long id, UpdateOrderDTO updateOrderDTO);

    OrderDTO getOrderById(Long orderId, Optional<String> currency);

    // let's assume if you pay with credit card we deduct $10 during the campaign period
    BigDecimal placeOrder(PaymentMethod paymentMethod, Long cartId, Long customerId);
}
