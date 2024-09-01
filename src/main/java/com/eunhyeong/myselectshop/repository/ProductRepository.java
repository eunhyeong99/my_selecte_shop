package com.eunhyeong.myselectshop.repository;

import com.eunhyeong.myselectshop.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product,Long> {
}
