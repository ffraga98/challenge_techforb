package com.techforb.challenge.service;

import com.techforb.challenge.entity.Customer;
import com.techforb.challenge.entity.Sale;
import com.techforb.challenge.entity.Supplier;
import com.techforb.challenge.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class SaleService implements IService<Sale,Long> {
    @Autowired
    private SaleRepository saleRepository;

    @Override
    public Sale add(Sale sale) {
        return saleRepository.save(sale);
    }

    @Override
    public List<Sale> findAll() {
        return saleRepository.findAll();
    }

    @Override
    public Sale findById(Long id) {
        return saleRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ));
    }

    @Override
    public void deleteById(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public Sale update(Sale element) {
        return saleRepository.save(element);
    }
}
