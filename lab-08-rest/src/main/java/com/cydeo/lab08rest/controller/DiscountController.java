package com.cydeo.lab08rest.controller;


import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/discount")
public class DiscountController {

    private final DiscountService discountService;

    public DiscountController(DiscountService discountService) {
        this.discountService = discountService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getCustomerList() {

        return ResponseEntity
                .ok(new ResponseWrapper("Discounts are successfully retrieved", discountService.getAllDiscount(), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateCustomer(@RequestBody DiscountDTO discountDTO) {
        discountService.updateDiscount(discountDTO);
        return ResponseEntity.ok(new ResponseWrapper("Discount is successfully updated", discountDTO, HttpStatus.CREATED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCustomer(@RequestBody DiscountDTO discountDTO) {
        discountService.createDiscount(discountDTO);
        return ResponseEntity.ok(new ResponseWrapper("Discount is successfully created", discountDTO, HttpStatus.CREATED));
    }

    @GetMapping("/{email}")
    public ResponseEntity<ResponseWrapper> getCustomerByEmail(@PathVariable("email") String name) {
        return ResponseEntity.ok(new ResponseWrapper("Discount is successfully retrieved", discountService.getDiscountByName(name), HttpStatus.OK));
    }
}
