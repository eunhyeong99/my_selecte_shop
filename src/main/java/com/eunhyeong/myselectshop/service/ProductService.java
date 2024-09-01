package com.eunhyeong.myselectshop.service;

import com.eunhyeong.myselectshop.dto.request.ProductMypriceRequestDto;
import com.eunhyeong.myselectshop.dto.request.ProductRequestDto;
import com.eunhyeong.myselectshop.dto.response.ProductResponseDto;
import com.eunhyeong.myselectshop.entity.Product;
import com.eunhyeong.myselectshop.repository.ProductRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional(readOnly = true)
public class ProductService {

    public final ProductRepository productRepository;

    public static final int MIN_MY_PRICE = 100;

    @Transactional
    public ProductResponseDto createProduct(ProductRequestDto requestDto) {
        Product product = productRepository.save(new Product(requestDto));
        return new ProductResponseDto(product);
    }

    @Transactional
    public ProductResponseDto updateProduct(Long id, ProductMypriceRequestDto requestDto) {
        int myprice = requestDto.getMyprice();
        if (myprice < MIN_MY_PRICE) {
            throw new IllegalArgumentException("유효하지 않은 관심 가격입니다. 최소 " + MIN_MY_PRICE + "원 이상으로 설정해 주세요.");
        }
        Product product = productRepository.findById(id).orElseThrow(() -> new NullPointerException("해당 상품을 찾을 수 없습니다."));

        product.update(requestDto);

        return new ProductResponseDto(product);
    }


    public List<ProductResponseDto> getProducts() {
        List<Product> producList = productRepository.findAll();
        List<ProductResponseDto> responseDtoList = new ArrayList<>();

        for (Product product : producList) {
            responseDtoList.add(new ProductResponseDto(product));
        }

        return responseDtoList;
    }
}
