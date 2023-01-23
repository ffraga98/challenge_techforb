package com.techforb.challenge.controller;

import com.techforb.challenge.entity.Customer;
import com.techforb.challenge.service.CustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/customer")
public class CustomerController {
    @Autowired
    private CustomerService customerService;

    @GetMapping("/")
    public List<Customer> findAll() {
        return customerService.findAll();
    }

    @PostMapping("/")
    public Customer add(@RequestBody Customer product) {
        return customerService.create(product);
    }

    @GetMapping("/{id}")
    public Customer findById(@PathVariable Long id) {
        return customerService.findById(id);
    }


    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        customerService.remove(id);
    }

    @PutMapping("/")
    public Customer update(@RequestBody Customer customer) {
        return customerService.update(customer);
    }

}
