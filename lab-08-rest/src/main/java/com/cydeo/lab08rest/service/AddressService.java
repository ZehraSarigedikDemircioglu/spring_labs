package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.AddressDTO;

import java.util.List;

public interface AddressService {

    List<AddressDTO> getAllAddress();

    AddressDTO getAddressByCustomerId(long customerId);

    AddressDTO createAddress(AddressDTO address);

    //    void updateAddress(AddressDTO address);
    AddressDTO updateAddress(AddressDTO address);

    List<AddressDTO> getAddressStartsWith(String pattern);

    List<AddressDTO> getAddressByCustomerIdAndName(Long customerId, String name);


}
