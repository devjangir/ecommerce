package com.jangir.ecom.ecommerce.dtos;

import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class FakeStoreProductDto {
    private Long id;
    private String title;
    private String category;
    private String description;
    private String image;
    private double price;
}

/*
id:1,
                    title:'...',
                    price:'...',
                    category:'...',
                    description:'...',
                    image:'.
 */
