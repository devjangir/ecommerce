package com.jangir.ecom.ecommerce.services;

import com.jangir.ecom.ecommerce.dtos.CategoryDto;
import com.jangir.ecom.ecommerce.dtos.GenericProductDto;
import com.jangir.ecom.ecommerce.exception.NotFoundException;

import java.util.List;
import java.util.UUID;

public interface ProductService {
    // Product getProductById(Long id)
    GenericProductDto getProductById(Long id) throws NotFoundException;

    GenericProductDto createProduct(GenericProductDto product);

    List<GenericProductDto> getAllProducts();

    GenericProductDto deleteProduct(Long id);
    GenericProductDto updateProduct(Long id, GenericProductDto product);
}
