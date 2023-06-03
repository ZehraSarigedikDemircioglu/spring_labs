package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;

import java.util.List;

public interface DiscountService {

    List<CustomerDTO> getAllDiscount();
    CustomerDTO updateDiscount(DiscountDTO discountDTO);
    CustomerDTO createDiscount(DiscountDTO discountDTO);
    CustomerDTO getDiscountByName(String name);
}
