package com.jangir.ecom.ecommerce.services;

import com.jangir.ecom.ecommerce.dtos.GenericProductDto;

import java.util.List;

public interface ProductService {
    // Product getProductById(Long id)
    GenericProductDto getProductById(Long id);

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);
    GenericProductDto updateProduct(Long id, GenericProductDto product);
}
