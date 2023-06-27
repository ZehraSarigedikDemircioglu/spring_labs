package com.cydeo.lab08rest.controller;

import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.dto.ProductRequest;
import com.cydeo.lab08rest.model.ResponseWrapper;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.http.HttpStatus;
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
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.findAll(), HttpStatus.OK));
    }

    @PutMapping
    public ResponseEntity<ResponseWrapper> updateProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully updated", productService.update(productDTO), HttpStatus.OK));
    }

    @PostMapping
    public ResponseEntity<ResponseWrapper> createProduct(@RequestBody ProductDTO productDTO) {
        return ResponseEntity.ok(new ResponseWrapper("Product is successfully saved", productService.create(productDTO), HttpStatus.OK));
    }

    @PostMapping("/categoryandprice")
    public ResponseEntity<ResponseWrapper> createProductByCategoryAndPrice(@RequestBody ProductRequest productRequest) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.createByCategoryAndPrice(productRequest.getCategoryList(), productRequest.getPrice()), HttpStatus.OK));
    }

    @GetMapping("/{name}")
    public ResponseEntity<ResponseWrapper> getProductListByName(@PathVariable("name") String name) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getProductName(name), HttpStatus.OK));
    }

    @GetMapping("/top3")
    public ResponseEntity<ResponseWrapper> getTop3ProductList() {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getTop3(), HttpStatus.OK));
    }

    @GetMapping("/price/{price}")
    public ResponseEntity<ResponseWrapper> getProductListByPrice(@PathVariable("price") BigDecimal price) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getProductByPrice(price), HttpStatus.OK));
    }

    @GetMapping("/price/{price}/quantity/{quantity}")
    public ResponseEntity<ResponseWrapper> getProductListByPriceAndQuantity(@PathVariable("price") BigDecimal price, @PathVariable("quantity") Integer quantity) {

        return ResponseEntity
                .ok(new ResponseWrapper("Products are successfully retrieved", productService.getByPriceAndQuantity(price, quantity), HttpStatus.OK));
    }

    @GetMapping("/category/{id}")
    public ResponseEntity<ResponseWrapper> getProductListByCategory(@PathVariable("id") long id) {
        return ResponseEntity.ok(new ResponseWrapper("Product retrieved", productService.getByCategory(id), HttpStatus.OK));
    }

    // you can call this method on postman with below url
    // localhost:8080/api/v1/product/byPagination?pageNo=1&pageSize=5&sortBy=price&sortDir=desc
    @GetMapping("/byPagination")
    public ResponseEntity<ResponseWrapper> getProductListByPagination(
            @RequestParam(value = "pageNo") int pageNo,
            @RequestParam(value = "pageSize") int pageSize,
            @RequestParam(value = "sortBy") String sortBy,
            @RequestParam(value = "sortDir") String sortDir) {
        return ResponseEntity.ok(new ResponseWrapper("Products are successfully retrieved.",
                productService.retrieveProductListByPagination(pageNo, pageSize, sortBy, sortDir), HttpStatus.OK));
    }
}
