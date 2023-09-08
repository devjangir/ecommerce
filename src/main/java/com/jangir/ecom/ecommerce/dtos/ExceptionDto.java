package com.jangir.ecom.ecommerce.dtos;

import lombok.Getter;
import org.springframework.http.HttpStatus;

@Getter
public class ExceptionDto {
    private final HttpStatus errorCode;
    private final String message;
    public ExceptionDto(HttpStatus errorCode, String message) {
        this.errorCode = errorCode;
        this.message = message;
    }
}
