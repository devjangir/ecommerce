package com.jangir.ecom.ecommerce.dtos;
import lombok.Getter;
import lombok.Setter;

@Setter
@Getter
public class GenericProductDto {
    private Long id;
    private String title;
    private String category;
    private String description;
    private String image;
    private double price;
}
