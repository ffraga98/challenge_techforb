package com.techforb.challenge.controller;

import com.techforb.challenge.entity.Supplier;
import com.techforb.challenge.service.SupplierService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/supplier")
public class SupplierController {
    @Autowired
    private SupplierService supplierService;

    @GetMapping
    public List<Supplier> findAll() {
        return supplierService.findAll();
    }

    @PostMapping("/")
    public Supplier add(@RequestBody Supplier product) {
        return supplierService.create(product);
    }

    @GetMapping("/{id}")
    public Supplier findById(@PathVariable Long id) {
        return supplierService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        supplierService.remove(id);
    }

    @PutMapping("/")
    public Supplier update(@RequestBody Supplier supplier) {
        return supplierService.update(supplier);
    }

}

