package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping("/api/v1/product")
public class ProductController {

    private final ProductService productService;

    public ProductController(ProductService productService) {
        this.productService = productService;
    }

    @GetMapping
    public ResponseEntity<ResponseWrapper> getAllProduct() {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.findAll()));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.update(productDTO)));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.create(productDTO)));
    }
    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> createProductByCategoryAndPrice(@RequestBody ProductDTO productDTO) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.createByCategoryAndPrice(productDTO)));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductName(@PathVariable String name) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getProductName(name)));
    }
    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getProductByTop3(@RequestBody ProductDTO productDTO) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getTop3()));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> getProductByPrice(@PathVariable BigDecimal price) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getProductByPrice(price)));
    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public ResponseEntity<ResponseWrapper> getProductByPriceAndQuantity(@PathVariable BigDecimal price, @PathVariable Integer quantity) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getByPriceAndQuantity(price, quantity)));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> getCategoryById(@PathVariable("id") long id) {
        return ResponseEntity.ok(new ResponseWrapper("Address are successfully retrieved", productService.getCategoryById(id)));
    }
}
