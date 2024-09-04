package com.eunhyeong.myselectshop.repository;

import com.eunhyeong.myselectshop.entity.Product;
import com.eunhyeong.myselectshop.entity.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    Page<Product> findAllByUser(User user, Pageable pageable);
}
