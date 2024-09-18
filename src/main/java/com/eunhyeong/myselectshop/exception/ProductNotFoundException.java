package com.eunhyeong.myselectshop.exception;

import org.springframework.http.HttpStatus;

public class ProductNotFoundException extends RuntimeException{
    public ProductNotFoundException(String message,int statusCode) {
        super(message);
    }
}