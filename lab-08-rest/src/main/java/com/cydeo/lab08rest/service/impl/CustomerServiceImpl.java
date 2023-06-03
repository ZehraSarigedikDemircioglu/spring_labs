package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.CustomerDTO;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements CustomerService {
    @Override
    public List<CustomerDTO> getAllCustomer() {
        return null;
    }

    @Override
    public CustomerDTO updateCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO createCustomer(CustomerDTO customerDTO) {
        return null;
    }

    @Override
    public CustomerDTO getCustomerByEmail(String email) {
        return null;
    }

    @Override
    public CustomerDTO findById(Long id) {
        return null;
    }
}
