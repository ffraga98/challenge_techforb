package com.techforb.challenge.repository;

import com.techforb.challenge.entity.Sale;
import com.techforb.challenge.entity.SalesItem;
import com.techforb.challenge.entity.Supplier;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;

public interface SalesItemRepository extends JpaRepository<SalesItem,Long> {
}
