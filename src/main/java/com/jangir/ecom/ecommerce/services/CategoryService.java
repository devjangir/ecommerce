package com.jangir.ecom.ecommerce.services;

import com.jangir.ecom.ecommerce.dtos.CategoryDto;
import com.jangir.ecom.ecommerce.dtos.GenericProductDto;

import java.util.List;

public interface CategoryService {
    List<GenericProductDto> getAllProductsInCategory(Long id);
    List<CategoryDto> getAllCategories();
}
