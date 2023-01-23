package com.techforb.challenge.repository;

import com.techforb.challenge.entity.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface ProductRepository extends JpaRepository<Product, Long> {
    List<Product> findAllByDeletedIsFalseAndSupplier_DeletedIsFalse();
    Optional<Product> findByIdAndDeletedIsTrue(Long id );
    List<Product> findByStockLessThanEqual(Long low_stock);

}
