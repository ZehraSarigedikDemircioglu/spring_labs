package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.CustomerDTO;

import java.util.List;

public interface CustomerService {
    List<CustomerDTO> getAllCustomer();
    CustomerDTO updateCustomer(CustomerDTO customerDTO);
    CustomerDTO createCustomer(CustomerDTO customerDTO);
    CustomerDTO getCustomerByEmail(String email);
    CustomerDTO findById(Long id);

    boolean existById(Long customerId);
}
