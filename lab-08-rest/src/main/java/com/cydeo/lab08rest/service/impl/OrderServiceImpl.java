package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.dto.UpdateOrderDTO;
import com.cydeo.lab08rest.entity.Order;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.exception.NotFoundException;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.OrderRepository;
import com.cydeo.lab08rest.service.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;
    private final MapperUtil mapperUtil;
    private final CustomerService customerService;
    private final CartService cartService;
    private final PaymentService paymentService;

    public OrderServiceImpl(OrderRepository orderRepository, MapperUtil mapperUtil, CustomerService customerService, CartService cartService, PaymentService paymentService) {
        this.orderRepository = orderRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
        this.cartService = cartService;
        this.paymentService = paymentService;
    }

    @Override
    public List<OrderDTO> getAllOrders() {
        return orderRepository.findAll()
                .stream()
                .map(order -> mapperUtil.convert(order, new OrderDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public List<OrderDTO> getOrderByEmail(String email) {
        return null;
    }

    @Override
    public OrderDTO createOrder(OrderDTO orderDTO) {
        Order order = orderRepository.save(mapperUtil.convert(orderDTO, new Order()));
        return mapperUtil.convert(order, new OrderDTO());
    }

    @Override
    public OrderDTO updateOrder(OrderDTO orderDTO) {

        //look for the orderId inside the database and throw the exception
        Order order = orderRepository.findById(orderDTO.getId()).orElseThrow(
                () -> new NotFoundException("Order could not be found."));

        //then we need to check if the order fields are exist or not
        validateRelatedFieldsAreExist(orderDTO);

        //if fields are exists, then convert orderDTO to order and save it
        Order willBeUpdatedOrder = mapperUtil.convert(orderDTO, new Order());
        Order updatedOrder = orderRepository.save(willBeUpdatedOrder);
        //convert again the updated one and return it
        return mapperUtil.convert(updatedOrder, new OrderDTO());
    }

    private void validateRelatedFieldsAreExist(OrderDTO orderDTO) {
        //in this method we have 3 different service and make sure they have those fields
        //we will create service and existById method and verify

        if (!customerService.existById(orderDTO.getCustomerId())) {
            throw new NotFoundException("Customer could not be found");
        }

        if (!paymentService.existById(orderDTO.getPaymentId())) {
            throw new NotFoundException("Payment could not be found");
        }

        if (!cartService.existById(orderDTO.getCartId())) {
            throw new NotFoundException("Cart could not be found");
        }
    }

    @Override
    public List<OrderDTO> getOrderByPaymentMethod(PaymentMethod paymentMethod) {
        return null;
    }

    @Override
    public OrderDTO updateOrderById(Long id, UpdateOrderDTO updateOrderDTO) {

        Order order = orderRepository.findById(id).orElseThrow(
                () -> new NotFoundException("Order could not be found."));
        //if we are getting the same value, it is not necessary to update the actual value

        boolean changeDetected = false;

        if (!order.getPaidPrice().equals(updateOrderDTO.getPaidPrice())) {
            order.setPaidPrice(updateOrderDTO.getPaidPrice());
            changeDetected = true;
        }

        if (!order.getTotalPrice().equals(updateOrderDTO.getTotalPrice())) {
            order.setTotalPrice(updateOrderDTO.getTotalPrice());
            changeDetected = true;
        }

        //if there is any change, update the order and return it
        if (changeDetected) {
            Order updateOrder = orderRepository.save(order);
            return mapperUtil.convert(updateOrder, new OrderDTO());
        } else {
            throw new RuntimeException("No changes detected");
        }
    }

}
