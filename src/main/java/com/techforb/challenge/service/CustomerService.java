package com.techforb.challenge.service;


import com.techforb.challenge.entity.Customer;
import com.techforb.challenge.entity.Supplier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements IService<Customer, Long> {

    @Override
    public List<Supplier> findAll() {
        return null;
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return Optional.empty();
    }

    @Override
    public void deleteById(Long id) {

    }

    @Override
    public Optional<Customer> update(Customer element) {
        return Optional.empty();
    }
}
