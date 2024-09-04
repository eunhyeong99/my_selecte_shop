package com.eunhyeong.myselectshop.repository;

import com.eunhyeong.myselectshop.entity.Product;
import com.eunhyeong.myselectshop.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product,Long> {
    List<Product> findAllByUser(User user);
}
