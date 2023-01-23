package com.techforb.challenge.controller;

import com.techforb.challenge.dto.command.SaleCDto;
import com.techforb.challenge.entity.Sale;
import com.techforb.challenge.service.SaleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/sale")
public class SaleController {
    @Autowired
    private SaleService saleService;

    @GetMapping
    public List<Sale> findAll() {
        return saleService.findAll();
    }

    @GetMapping("/")
    public List<Sale> getSalesOfTheDay(@RequestBody SaleCDto sale) {
        return saleService.getSalesOfTheDay(sale);
    }
    @PostMapping("/")
    public Sale add(@RequestBody SaleCDto sale) {
        return saleService.create(sale);
    }
    @GetMapping("/supplier/{id}")
    public List<Sale> findBySupplierProducts(@PathVariable Long id) {
        return saleService.getSalesBySupplierId(id);
    }

    @GetMapping("/{id}")
    public Sale findById(@PathVariable Long id) {
        return saleService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        saleService.remove(id);
    }
}
