package com.techforb.challenge.service;

import com.techforb.challenge.entity.Product;
import com.techforb.challenge.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IService<Product, Long> {
    @Override
    public List<Supplier> findAll() {
        return null;
    }

    @Override
    public Optional<Product> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Product> update(Product element) {
        return Optional.empty();
    }
}
