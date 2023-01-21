package com.techforb.challenge.service;

import com.techforb.challenge.entity.Customer;
import com.techforb.challenge.entity.Supplier;
import com.techforb.challenge.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SupplierService implements IService<Supplier, Long> {
    @Autowired
    private SupplierRepository supplierRepository;

    @Override
    public Supplier add(Supplier element) {
        return supplierRepository.save(element);
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAll();
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(Long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public Supplier update(Supplier element) {
        return supplierRepository.save(element);
    }
}
