package com.techforb.challenge.service;

import com.techforb.challenge.entity.Supplier;
import com.techforb.challenge.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SupplierService implements IService<Supplier, Long> {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Optional<Supplier> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Supplier> update(Supplier element) {
        return Optional.empty();
    }
}
