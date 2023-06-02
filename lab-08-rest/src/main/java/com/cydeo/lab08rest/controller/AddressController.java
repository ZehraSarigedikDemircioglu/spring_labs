package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllAddresses() {

        return ResponseEntity
                .ok(new ResponseWrapper("Address are successfully retrieved", addressService.getAllAddress()));
    }

    //    @PutMapping
//    public ResponseEntity<Void> updateAddressById(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) {
//        addressService.updateAddress(addressDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
    @PutMapping
    public AddressDTO updateAddressById(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) {
        return addressService.updateAddress(addressDTO);
    }

    @PostMapping
    public AddressDTO createAddress(@RequestBody AddressDTO addressDTO) {
        return addressService.createAddress(addressDTO);
    }

    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressByStartsWith(@PathVariable("address") String pattern) {
        return ResponseEntity.ok(new ResponseWrapper("Address are successfully retrieved", addressService.getAddressStartsWith(pattern)));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressByCustomerId(@PathVariable("id") long customerId) {
        return ResponseEntity.ok(new ResponseWrapper("Address are successfully retrieved", addressService.getAddressByCustomerId(customerId)));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressByCustomerId(@PathVariable("customerId") long customerId, @PathVariable("name") String name) {
        return ResponseEntity.ok(new ResponseWrapper("Address are successfully retrieved", addressService.getAddressByCustomerIdAndName(customerId, name)));
    }


}
