package com.jangir.ecom.ecommerce.controllers;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.jangir.ecom.ecommerce.services.ProductService;

@RestController
@RequestMapping("/products")

public class ProductController {

    ProductService productService;
	
	public ProductController(@Qualifier("fakeStoreProductService") ProductService productService) {
		this.productService = productService;
	}

    @GetMapping("{id}")
	public String getProductById(@PathVariable("id") Long id) {
		return this.productService.getProductById(id);
	}

	@GetMapping("/hello")
    public String hello(@RequestParam(value = "name", defaultValue = "World") String name) {
      return String.format("Hello %s!", name);
    }
}
