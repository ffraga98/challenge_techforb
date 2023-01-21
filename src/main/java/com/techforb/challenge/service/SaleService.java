package com.techforb.challenge.service;

import com.techforb.challenge.entity.Sale;
import com.techforb.challenge.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService implements IService<Sale,Long> {
    @Override
    public List<Supplier> findAll() {
        return null;
    }

    @Override
    public Optional<Sale> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Sale> update(Sale element) {
        return Optional.empty();
    }
}
