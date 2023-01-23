package com.techforb.challenge.repository;

import com.techforb.challenge.entity.Sale;
import com.techforb.challenge.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Long> {

    List<Sale> getSalesByDateIs(LocalDate d);
    @Query( "from Sale s join s.items as item join item.product as p where p.supplier.id = ?1")
    List <Sale> getSalesBySupplier(Long id);

}