package com.eunhyeong.myselectshop.dto.response;

import com.eunhyeong.myselectshop.entity.Product;
import lombok.Getter;

@Getter
public class ProductResponseDto {
    private final Long id;
    private final String title;
    private final String link;
    private final String image;
    private final int lprice;
    private final int myprice;

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.link = product.getLink();
        this.image = product.getImage();
        this.lprice = product.getLprice();
        this.myprice = product.getMyprice();
    }
}