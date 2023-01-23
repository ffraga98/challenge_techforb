package com.techforb.challenge.service;


import com.techforb.challenge.entity.Customer;
import com.techforb.challenge.repository.AddressRepository;
import com.techforb.challenge.repository.CustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class CustomerService implements IService<Customer,Customer, Long> {
    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private AddressRepository addressRepository;
    @Override
    public Customer create(Customer element) {
        Customer customer = null;
        Long id = element.getId();
        if ( id != null ) {
           customer = this.restore(id);
        }else{
           customer = customerRepository.save(element);
        }
        return customer;
    }

    private Customer restore( Long id ) {
        Customer c = customerRepository.findById( id ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        c.setDeleted(Boolean.FALSE);
        return customerRepository.save(c);
    }

    @Override
    public List<Customer> findAll() {
        return customerRepository.findAllByDeletedIsFalse();
    }

    @Override
    public Customer findById(Long id) {
        return customerRepository.findByIdAndDeletedFalse(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void remove(Long id) {
        customerRepository.deleteById(id);
    }

    @Override
    public Customer update(Customer element) {
        Long id = element.getId();
        //Agregar excepción de que debe dar un ID para poder actualizar.
        Customer customer = this.findById(id);
        customer.update(element);
        addressRepository.save(customer.getAddress());
        return customerRepository.save(customer);
    }
}
