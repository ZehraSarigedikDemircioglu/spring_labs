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
    public ResponseEntity<ResponseWrapper> getAddressList() {

        return ResponseEntity
                .ok(new ResponseWrapper("Addresses are successfully retrieved", addressService.getAllAddress(), HttpStatus.OK));
    }

    //    @PutMapping
//    public ResponseEntity<Void> updateAddressById(@PathVariable("id") Long id, @RequestBody AddressDTO addressDTO) {
//        addressService.updateAddress(addressDTO);
//        return ResponseEntity.status(HttpStatus.OK).build();
//    }
    @PutMapping
    public ResponseEntity<ResponseWrapper> updateAddress(@RequestBody AddressDTO addressDTO) {
        addressService.updateAddress(addressDTO);
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully updated", addressDTO, HttpStatus.CREATED));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createAddress(@RequestBody AddressDTO addressDTO) {
        addressService.createAddress(addressDTO);
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully created", addressDTO, HttpStatus.CREATED));
    }

    @GetMapping("/startsWith/{address}")
    public ResponseEntity<ResponseWrapper> getAddressListByStartsWithAddress(@PathVariable("address") String pattern) {
        return ResponseEntity.ok(new ResponseWrapper("Addresses are successfully retrieved", addressService.getAddressStartsWith(pattern), HttpStatus.OK));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerId(@PathVariable("id") long customerId) {
        return ResponseEntity.ok(new ResponseWrapper("Address is successfully retrieved", addressService.getAddressByCustomerId(customerId), HttpStatus.OK));
    }

    @GetMapping("/customer/{customerId}/name/{name}")
    public ResponseEntity<ResponseWrapper> getAddressListByCustomerAndName(@PathVariable("customerId") long customerId, @PathVariable("name") String name) {
        return ResponseEntity.ok(new ResponseWrapper("Address are successfully retrieved", addressService.getAddressByCustomerIdAndName(customerId, name), HttpStatus.OK));
    }


}
