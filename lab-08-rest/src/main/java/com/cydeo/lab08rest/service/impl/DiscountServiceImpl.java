package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.dto.DiscountDTO;
import com.cydeo.lab08rest.service.DiscountService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DiscountServiceImpl implements DiscountService {
    @Override
    public List<CustomerDTO> getAllDiscount() {
        return null;
    }

    @Override
    public CustomerDTO updateDiscount(DiscountDTO discountDTO) {
        return null;
    }

    @Override
    public CustomerDTO createDiscount(DiscountDTO discountDTO) {
        return null;
    }

    @Override
    public CustomerDTO getDiscountByName(String name) {
        return null;
    }
}
