package com.cydeo.lab08rest.service;

import com.cydeo.lab08rest.dto.ProductDTO;

import java.math.BigDecimal;
import java.util.List;
public interface ProductService {

    List<ProductDTO> findAll();

    ProductDTO update(ProductDTO productDTO);

    ProductDTO create(ProductDTO productDTO);
    List<ProductDTO> createByCategoryAndPrice(List<Long> categoryList, BigDecimal price);

    ProductDTO getProductName(String name);
    List<ProductDTO> getTop3();
    Integer getProductByPrice(BigDecimal price);
    List<ProductDTO> getByPriceAndQuantity(BigDecimal price, Integer quantity);
    List<ProductDTO> getByCategory(long id);
    List<ProductDTO> retrieveProductListByPagination(int pageNo, int pageSize, String sortBy, String sortDir);
}
