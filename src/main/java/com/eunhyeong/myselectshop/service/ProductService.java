package com.eunhyeong.myselectshop.service;

import com.eunhyeong.myselectshop.dto.request.ProductRequestDto;
import com.eunhyeong.myselectshop.dto.response.ProductResponseDto;
import com.eunhyeong.myselectshop.entity.Product;
import com.eunhyeong.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    public final ProductRepository productRepository;

    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }
}
