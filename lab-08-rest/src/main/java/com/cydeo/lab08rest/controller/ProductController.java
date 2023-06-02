package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.AddressDTO;
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
    public ResponseEntity<ResponseWrapper> getProductList() {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.findAll()));
    }

    @PutMapping
    public ProductDTO updateProduct(@RequestBody ProductDTO productDTO) {

        return productService.update(productDTO);
    }

    @PostMapping
    public ProductDTO createProduct(@RequestBody ProductDTO productDTO) {

        return productService.create(productDTO);
    }
    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> createProductByCategoryAndPrice(@RequestBody ProductDTO productDTO) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.createByCategoryAndPrice(productDTO)));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductListByName(@PathVariable("name") String name) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getProductName(name)));
    }
    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getTop3ProductList() {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getTop3()));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable("price") BigDecimal price) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getProductByPrice(price)));
    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public ResponseEntity<ResponseWrapper> getProductListByPriceAndQuantity(@PathVariable("price") BigDecimal price, @PathVariable("quantity") Integer quantity) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getByPriceAndQuantity(price, quantity)));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> getProductListByCategory(@PathVariable("id") long id) {
        return ResponseEntity.ok(new ResponseWrapper("Product retrieved", productService.getCategoryById(id)));
    }
}
