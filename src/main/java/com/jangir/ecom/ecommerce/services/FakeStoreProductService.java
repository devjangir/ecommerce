package com.jangir.ecom.ecommerce.services;
import com.jangir.ecom.ecommerce.dtos.CategoryDto;
import com.jangir.ecom.ecommerce.dtos.FakeStoreProductDto;
import com.jangir.ecom.ecommerce.dtos.GenericProductDto;
import com.jangir.ecom.ecommerce.exception.NotFoundException;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RequestCallback;
import org.springframework.web.client.ResponseExtractor;
import org.springframework.web.client.RestTemplate;

import java.util.List;
import java.util.UUID;

@Service("fakeStoreProductService")
public class FakeStoreProductService implements ProductService {
    private RestTemplateBuilder restTemplateBuilder;
    private final String specificProductRequestUrl = "https://fakestoreapi.com/products/{id}";
    private final String productRequestBaseUrl = "https://fakestoreapi.com/products";

    private GenericProductDto convertToGenericProductDto(FakeStoreProductDto fakeStoreProductDto) {
        GenericProductDto product = new GenericProductDto();
        product.setId(fakeStoreProductDto.getId());
        product.setTitle(fakeStoreProductDto.getTitle());
        product.setDescription(fakeStoreProductDto.getDescription());
        product.setImage(fakeStoreProductDto.getImage());
        product.setPrice(fakeStoreProductDto.getPrice());
        product.setCategory(fakeStoreProductDto.getCategory());
        return product;
    }
    public  FakeStoreProductService(RestTemplateBuilder restTemplateBuilder) {
        this.restTemplateBuilder = restTemplateBuilder;
    }


    public GenericProductDto getProductById(Long id) throws NotFoundException {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<FakeStoreProductDto> response = restTemplate.getForEntity(specificProductRequestUrl, FakeStoreProductDto.class, id);
        FakeStoreProductDto fakeStoreProductDto = response.getBody();
        if(fakeStoreProductDto == null) {
            throw new NotFoundException("Product with id: "+id+" does not exist");
        }
        return convertToGenericProductDto(fakeStoreProductDto);
    }

    public GenericProductDto createProduct(GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto> response = restTemplate.postForEntity(productRequestBaseUrl,product, GenericProductDto.class);
        return response.getBody();
    }

    public List<GenericProductDto> getAllProducts() {
        RestTemplate restTemplate = restTemplateBuilder.build();
        ResponseEntity<GenericProductDto[]> response = restTemplate.getForEntity(productRequestBaseUrl, GenericProductDto[].class);
        return List.of(response.getBody());
    }

    public GenericProductDto deleteProduct(Long id) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(GenericProductDto.class);
        ResponseExtractor<ResponseEntity<GenericProductDto>> responseExtractor = restTemplate.responseEntityExtractor(GenericProductDto.class);
        ResponseEntity<GenericProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.GET, requestCallback, responseExtractor, id);
        return response.getBody();
    }

    public GenericProductDto updateProduct(Long id, GenericProductDto product) {
        RestTemplate restTemplate = restTemplateBuilder.build();
        RequestCallback requestCallback = restTemplate.acceptHeaderRequestCallback(GenericProductDto.class);
        ResponseExtractor<ResponseEntity<GenericProductDto>> responseExtractor = restTemplate.responseEntityExtractor(GenericProductDto.class);
        ResponseEntity<GenericProductDto> response = restTemplate.execute(specificProductRequestUrl, HttpMethod.PUT, requestCallback, responseExtractor, id, product);
        return response.getBody();
    }
}
