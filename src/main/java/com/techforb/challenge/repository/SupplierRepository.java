package com.techforb.challenge.repository;

import com.techforb.challenge.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.Optional;

public interface SupplierRepository extends JpaRepository<Supplier, Long> {
    public List<Supplier> findAllByDeletedIsFalse();
    @Query( "from Supplier as s join fetch s.supplied_products as p where p.deleted = false and s.deleted = false")
    public List<Supplier> findAllWithAvailableProducts();
}
