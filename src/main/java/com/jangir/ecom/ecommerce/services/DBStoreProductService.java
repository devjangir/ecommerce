package com.jangir.ecom.ecommerce.services;

import com.jangir.ecom.ecommerce.dtos.CategoryDto;
import com.jangir.ecom.ecommerce.dtos.GenericProductDto;
import com.jangir.ecom.ecommerce.exception.NotFoundException;
import com.jangir.ecom.ecommerce.models.Category;
import com.jangir.ecom.ecommerce.models.Product;
import com.jangir.ecom.ecommerce.repositories.ProductRepository;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Primary
@Service("dBStoreProductService")
public class DBStoreProductService implements ProductService {
    private final ProductRepository productRepository;
    public DBStoreProductService(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public GenericProductDto getProductById(Long id) throws NotFoundException {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            Product p = product.get();
            GenericProductDto productDTO = new GenericProductDto();
            productDTO.setId(id);
            productDTO.setTitle(p.getTitle());
            productDTO.setDescription(p.getDescription());
            productDTO.setImage(p.getImage());
            productDTO.setCategory(p.getCategory().getName());
            productDTO.setPrice(p.getPrice());
            return productDTO;
        }
        throw new NotFoundException("Product with id: "+id+" does not exist");
    }

    @Override
    public GenericProductDto createProduct(GenericProductDto product) {
        System.out.println(product);
        Product p = new Product();
        p.setTitle(product.getTitle());
        p.setImage(product.getImage());
        p.setPrice(product.getPrice());
        p.setDescription(product.getDescription());

        Category category = new Category();
        category.setName(product.getCategory());
        p.setCategory(category);
        productRepository.save(p);
        return product;
    }

    @Override
    public List<GenericProductDto> getAllProducts() {
        List<GenericProductDto> products = new ArrayList<GenericProductDto>();
        List<Product> dbProducts = productRepository.findAll();
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
        return products;
    }

    @Override
    public GenericProductDto deleteProduct(Long id) {
        Optional<Product> product = productRepository.findById(id);
        if(product.isPresent()) {
            Product p = product.get();
            GenericProductDto productDTO = new GenericProductDto();
            productDTO.setId(id);
            productDTO.setTitle(p.getTitle());
            productDTO.setDescription(p.getDescription());
            productDTO.setImage(p.getImage());
            productDTO.setCategory(p.getCategory().getName());
            productDTO.setPrice(p.getPrice());
            productRepository.deleteById(id);
            return productDTO;
        }
        return null;
    }

    @Override
    public GenericProductDto updateProduct(Long id, GenericProductDto product) {
        Optional<Product> dbProduct = productRepository.findById(id);
        if(dbProduct.isPresent()) {
            Product p = dbProduct.get();
            p.setTitle(product.getTitle());
            p.setDescription(product.getDescription());
            p.setPrice(product.getPrice());
            p.setImage(product.getImage());
            productRepository.save(p);
            return product;
        }
        return null;
    }
}
