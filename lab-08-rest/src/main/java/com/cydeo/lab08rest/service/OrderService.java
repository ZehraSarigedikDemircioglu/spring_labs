package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.entity.Payment;
import com.cydeo.lab08rest.enums.PaymentMethod;

import java.util.List;

public interface OrderService {

    List<OrderDTO> getAllOrders();

    List<OrderDTO> getOrderByEmail(String email);

    OrderDTO createOrder(OrderDTO orderDTO);

    OrderDTO updateOrder(OrderDTO orderDTO);

    List<OrderDTO> getOrderByPaymentMethod(PaymentMethod paymentMethod);
}
