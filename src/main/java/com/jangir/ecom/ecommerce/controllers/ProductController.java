package com.jangir.ecom.ecommerce.controllers;
import com.jangir.ecom.ecommerce.dtos.GenericProductDto;
import com.jangir.ecom.ecommerce.exception.NotFoundException;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.*;

import com.jangir.ecom.ecommerce.services.ProductService;
import java.util.List;

@RestController
@RequestMapping("/products")

public class ProductController {

    ProductService productService;
	public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
		this.productService = productService;
	}

    @GetMapping("{id}")
	public GenericProductDto getProductById(@PathVariable("id") Long id) throws NotFoundException {
		return this.productService.getProductById(id);
	}

	@GetMapping
	public List<GenericProductDto> getAllProducts() {
		return this.productService.getAllProducts();
	}

	@PostMapping
	public GenericProductDto createProduct(@RequestBody GenericProductDto product) {
		return this.productService.createProduct(product);
	}

	@DeleteMapping("{id}")
	public GenericProductDto deleteProduct(@PathVariable("id") Long id) {
		return productService.deleteProduct(id);
	}

	@PutMapping("{id}")
	public GenericProductDto updateProduct(@PathVariable("id") Long id, @RequestBody GenericProductDto product) {
		return productService.updateProduct(id, product);
	}
}
