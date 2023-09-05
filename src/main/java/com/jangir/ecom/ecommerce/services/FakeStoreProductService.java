package com.jangir.ecom.ecommerce.services;
import org.springframework.stereotype.Service;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    public String getProductById(Long id) {
        return "The Product id is: " + id;
    }
}
