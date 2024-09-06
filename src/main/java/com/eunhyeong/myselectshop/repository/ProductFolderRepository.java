package com.eunhyeong.myselectshop.repository;

import com.eunhyeong.myselectshop.entity.Folder;
import com.eunhyeong.myselectshop.entity.Product;
import com.eunhyeong.myselectshop.entity.ProductFolder;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface ProductFolderRepository extends JpaRepository<ProductFolder,Long> {
    Optional<ProductFolder> findByProductAndFolder(Product product, Folder folder);
}
