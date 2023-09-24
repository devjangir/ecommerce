package com.jangir.ecom.ecommerce.dtos;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
public class CategoryDto {
    private Long id;
    private String name;
    private List<GenericProductDto> products = new ArrayList<GenericProductDto>();
}
