package com.jangir.ecom.ecommerce.services;

import com.jangir.ecom.ecommerce.dtos.CategoryDto;
import com.jangir.ecom.ecommerce.dtos.GenericProductDto;
import com.jangir.ecom.ecommerce.models.Category;
import com.jangir.ecom.ecommerce.models.Product;
import com.jangir.ecom.ecommerce.repositories.CategoryRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service("dBStoreCategoryService")
public class DBStoreCategoryService implements CategoryService {
    private CategoryRepository categoryRepository;
    DBStoreCategoryService(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }
    @Override
    public List<GenericProductDto> getAllProductsInCategory(Long id) {
        Optional<Category> category = categoryRepository.findById(id);
        List<GenericProductDto> products = new ArrayList<GenericProductDto>();
        if(category.isPresent()) {
            System.out.println(category.get().getProducts());
            List<Product> dbProducts = category.get().getProducts();
            for(Product p: dbProducts) {
                GenericProductDto productDTO = new GenericProductDto();
                productDTO.setId(p.getId());
                productDTO.setTitle(p.getTitle());
                productDTO.setDescription(p.getDescription());
                productDTO.setImage(p.getImage());
                productDTO.setCategory(p.getCategory().getName());
                productDTO.setPrice(p.getPrice());
                products.add(productDTO);
            }
        }
        return products;
    }

    @Override
    public List<CategoryDto> getAllCategories() {
        List<CategoryDto> categoryDtos = new ArrayList<CategoryDto>();
        List<Category> categories = categoryRepository.findAll();
        for(Category c: categories) {
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.setId(c.getId());
            categoryDto.setName(c.getName());
            categoryDtos.add(categoryDto);
        }
        return categoryDtos;
    }
}
