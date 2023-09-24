package com.jangir.ecom.ecommerce.controllers;

import com.jangir.ecom.ecommerce.dtos.CategoryDto;
import com.jangir.ecom.ecommerce.dtos.GenericProductDto;
import com.jangir.ecom.ecommerce.models.Category;
import com.jangir.ecom.ecommerce.repositories.CategoryRepository;
import com.jangir.ecom.ecommerce.services.CategoryService;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/products/categories")
public class CategoryController {
    private CategoryService categoryService;
    public CategoryController(@Qualifier("dBStoreCategoryService") CategoryService categoryService) {
        this.categoryService = categoryService;
    }

    @GetMapping
    public List<CategoryDto> getAllCategories() {
        return categoryService.getAllCategories();
    }

    @GetMapping("{id}")
    public List<GenericProductDto> getAllProductsInCategory(@PathVariable Long id) {
        return categoryService.getAllProductsInCategory(id);
    }

}
