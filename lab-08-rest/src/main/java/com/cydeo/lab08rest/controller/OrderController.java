package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.OrderDTO;
import com.cydeo.lab08rest.enums.PaymentMethod;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import com.cydeo.lab08rest.service.OrderService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/order")
public class OrderController {

    private final OrderService orderService;

    public OrderController(OrderService orderService) {
        this.orderService = orderService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getOrderList() {

        return ResponseEntity
                .ok(new ResponseWrapper("Orders are successfully retrieved", orderService.getAllOrders(), HttpStatus.OK));
    }
    @PutMapping
    public ResponseEntity<ResponseWrapper> updateOrder(@RequestBody OrderDTO orderDTO) {
        orderService.updateOrder(orderDTO);
        return ResponseEntity.ok(new ResponseWrapper("Order is successfully updated", orderDTO, HttpStatus.CREATED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createOrder(@RequestBody OrderDTO orderDTO) {
        orderService.createOrder(orderDTO);
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully created", orderDTO, HttpStatus.CREATED));
    }

    @GetMapping("/paymentMethod/{paymentMethod}")
    public ResponseEntity<ResponseWrapper> getOrderByPaymentMethod(@PathVariable("paymentMethod")PaymentMethod paymentMethod) {
        return ResponseEntity.ok(new ResponseWrapper("Payment method is successfully retrieved", orderService.getOrderByPaymentMethod(paymentMethod), HttpStatus.OK));
    }

    @GetMapping("/email/{email}")
    public ResponseEntity<ResponseWrapper> getOrderByEmail(@PathVariable("email") String email) {
        return ResponseEntity.ok(new ResponseWrapper("Order is successfully retrieved", orderService.getOrderByEmail(email), HttpStatus.OK));
    }

}
