package com.techforb.challenge.repository;

import com.techforb.challenge.entity.Sale;
import com.techforb.challenge.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SaleRepository extends JpaRepository<Sale,Long> {

    List<Sale> getSalesByDateIs(LocalDate d);

    List<Sale> getSalesByProduct_Supplier(Supplier supplier);

}
