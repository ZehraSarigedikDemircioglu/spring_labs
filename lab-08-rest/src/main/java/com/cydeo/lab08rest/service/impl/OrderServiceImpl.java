package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements OrderService {

    @Override
    public List<OrderDTO> getAllOrders() {
        return null;
    }

    @Override
    public List<OrderDTO> getOrderByEmail(String email) {
        return null;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {
        return null;
    }

    @Override
    public List<OrderDTO> getOrderByPaymentMethod(PaymentMethod paymentMethod) {
        return null;
    }
}
