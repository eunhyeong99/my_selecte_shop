package com.eunhyeong.myselectshop.dto.response;

import com.eunhyeong.myselectshop.entity.Product;
import com.eunhyeong.myselectshop.entity.ProductFolder;
import lombok.Getter;

import java.util.ArrayList;
import java.util.List;

@Getter
public class ProductResponseDto {
    private final Long id;
    private final String title;
    private final String link;
    private final String image;
    private final int lprice;
    private final int myprice;

    private List<FolderResponseDto> productFolderList = new ArrayList<>();

    public ProductResponseDto(Product product) {
        this.id = product.getId();
        this.title = product.getTitle();
        this.link = product.getLink();
        this.image = product.getImage();
        this.lprice = product.getLprice();
        this.myprice = product.getMyprice();
        for (ProductFolder productFolder : product.getProductFolderList()) {
            productFolderList.add(new FolderResponseDto(productFolder.getFolder()));
        }
    }
}