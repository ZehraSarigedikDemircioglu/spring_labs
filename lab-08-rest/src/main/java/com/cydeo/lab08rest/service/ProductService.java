package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;
public interface ProductService {

    List<ProductDTO> findAll();

    ProductDTO update(ProductDTO productDTO);

    ProductDTO create(ProductDTO productDTO);
    ProductDTO createByCategoryAndPrice(ProductDTO productDTO);

    ProductDTO getProductName(String name);
    List<ProductDTO> getTop3();
    ProductDTO getProductByPrice(BigDecimal price);
    ProductDTO getByPriceAndQuantity(BigDecimal price, Integer quantity);
    ProductDTO getCategoryById( Long id);
}
