package com.techforb.challenge.repository;

import com.techforb.challenge.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ProductRepository extends JpaRepository<Product, Long> {
}
