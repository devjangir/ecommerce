package com.jangir.ecom.ecommerce.models;
import lombok.Getter;
import lombok.Setter;

public class Product extends BaseModel {
    private String title;
    private String description;
    private String image;
    private Category category;
    private double price;    
}
