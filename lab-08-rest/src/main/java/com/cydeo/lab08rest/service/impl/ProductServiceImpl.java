package com.cydeo.lab08rest.service.impl;

import com.cydeo.lab08rest.dto.AddressDTO;
import com.cydeo.lab08rest.dto.ProductDTO;
import com.cydeo.lab08rest.entity.Address;
import com.cydeo.lab08rest.entity.Product;
import com.cydeo.lab08rest.mapper.MapperUtil;
import com.cydeo.lab08rest.repository.ProductRepository;
import com.cydeo.lab08rest.service.ProductService;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;
    private final MapperUtil mapperUtil;

    public ProductServiceImpl(ProductRepository productRepository, MapperUtil mapperUtil) {
        this.productRepository = productRepository;
        this.mapperUtil = mapperUtil;
    }

    @Override
    public List<ProductDTO> findAll() {
        return productRepository.findAll()
                .stream()
                .map(student -> mapperUtil.convert(student, new ProductDTO()))
                .collect(Collectors.toList());
    }

    @Override
    public ProductDTO update(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO create(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO createByCategoryAndPrice(ProductDTO productDTO) {
        return null;
    }

    @Override
    public ProductDTO getProductName(String name) {
        return null;
    }

    @Override
    public List<ProductDTO> getTop3() {
        return null;
    }

    @Override
    public ProductDTO getProductByPrice(BigDecimal price) {
        return null;
    }

    @Override
    public ProductDTO getByPriceAndQuantity(BigDecimal price, Integer quantity) {
        return null;
    }

    @Override
    public ProductDTO getCategoryById(Long id) {
        return null;
    }
}
