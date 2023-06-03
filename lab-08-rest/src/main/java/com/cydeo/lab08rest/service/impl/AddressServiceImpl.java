package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Customer;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.AddressRepository;
import com.cydeo.lab08rest.service.AddressService;
import com.cydeo.lab08rest.service.CustomerService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;
@Service
public class AddressServiceImpl implements AddressService {

    private final AddressRepository addressRepository;
    private final MapperUtil mapperUtil;
    private final CustomerService customerService;

    public AddressServiceImpl(AddressRepository addressRepository, MapperUtil mapperUtil, CustomerService customerService) {
        this.addressRepository = addressRepository;
        this.mapperUtil = mapperUtil;
        this.customerService = customerService;
    }

    @Override
    public List<AddressDTO> getAllAddress() {
        List<Address> list = addressRepository.findAll();
        return list.stream().map(obj -> mapperUtil.convert(obj, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAddressByCustomerId(long customerId) {
        return addressRepository.findById(customerId).stream().map(add -> mapperUtil.convert(add, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public AddressDTO createAddress(AddressDTO addressDTO) {
        addressRepository.save(mapperUtil.convert(addressDTO, new Address()));
        return addressDTO;
    }

    @Override
    public AddressDTO updateAddress(AddressDTO addressDTO) {

        Address addressToUpdate = mapperUtil.convert(addressDTO, new Address());
        Customer customer = mapperUtil.convert(customerService.findById(addressDTO.getCustomerId()), new Customer());
        addressToUpdate.setCustomer(customer);
        addressRepository.save(addressToUpdate);
        return addressDTO;
    }

    @Override
    public List<AddressDTO> getAddressStartsWith(String pattern) {
        return addressRepository.findAllByStreetStartingWith(pattern)
                .stream().map(obj -> mapperUtil.convert(obj, new AddressDTO())).collect(Collectors.toList());
    }

    @Override
    public List<AddressDTO> getAddressByCustomerIdAndName(Long customerId, String name) {
        return null;
    }

//    @Override
//        public List<AddressDTO> getAddressByCustomerIdAndName(Long customerId, String name) {
//        return addressRepository.findAllByCustomerAndName(customerId, name).stream
//                .map(obj -> mapperUtil.convert(obj, new AddressDTO()))
//                .collect(Collectors.toList());
//    }
}
