package com.youtubekipper.crudjavaspring.repositories;

import com.youtubekipper.crudjavaspring.domain.product.Product;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ProductRepository extends JpaRepository<Product, String> {
    List<Product> findAllByActiveTrue();
}
