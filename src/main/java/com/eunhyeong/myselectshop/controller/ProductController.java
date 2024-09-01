package com.eunhyeong.myselectshop.controller;

import com.eunhyeong.myselectshop.dto.request.ProductMypriceRequestDto;
import com.eunhyeong.myselectshop.dto.request.ProductRequestDto;
import com.eunhyeong.myselectshop.dto.response.ProductResponseDto;
import com.eunhyeong.myselectshop.service.ProductService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class ProductController {

    private final ProductService productService;


    @PostMapping("/products")
    public ProductResponseDto createProduct(@RequestBody ProductRequestDto requestDto) {
        return productService.createProduct(requestDto);
    }

    // 관심 상품 희망 최저가 등록하기
    @PutMapping("/products/{id}")
    public ProductResponseDto updateProduct(@PathVariable Long id, @RequestBody ProductMypriceRequestDto requestDto) {
        // 응답 보내기
        return productService.updateProduct(id, requestDto);
    }


}
