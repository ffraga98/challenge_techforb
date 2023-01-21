package com.techforb.challenge.service;


import com.techforb.challenge.entity.Customer;
import com.techforb.challenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements IService<Customer, Long> {
    @Autowired
    private CustomerRepository customerRepository;

    @Override
    public Customer add(Customer element) {
        return customerRepository.save(element);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void deleteById(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer update(Customer element) {
        return customerRepository.save(element);
    }
}
