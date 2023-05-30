package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.ResponseWrapper;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.service.AddressService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/v1/address")
public class AddressController {

    private final AddressService addressService;

    public AddressController(AddressService addressService) {
        this.addressService = addressService;
    }

    //    @GetMapping
//    public List<AddressDTO> getAllAddresses(){
//        return addressService.getAllCourses();
//    }
    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllCourses() {

        return ResponseEntity
//                .status(HttpStatus.ACCEPTED)
                .ok(new ResponseWrapper("Address are successfully retrieved", addressService.getAllCourses()));
//                .header("Version", "Cydeo.V3")
//                .body(new ResponseWrapper("Address are successfully retrieved", addressService.getAllCourses()));
    }

    @GetMapping("/customer/{id}")
    public ResponseEntity<ResponseWrapper> getCourseById(@PathVariable("id") long customerId) {
        return ResponseEntity.ok(new ResponseWrapper("Address are successfully retrieved", addressService.getAddressById(customerId)));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createCourse() {
        return ResponseEntity.created(new ResponseWrapper("Address is created"), addressService.createAddress());
    }
}
