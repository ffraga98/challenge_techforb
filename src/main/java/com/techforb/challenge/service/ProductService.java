package com.techforb.challenge.service;

import com.techforb.challenge.entity.Customer;
import com.techforb.challenge.entity.Product;
import com.techforb.challenge.entity.Supplier;
import com.techforb.challenge.repository.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService implements IService<Product, Long> {
    @Autowired
    private ProductRepository productRepository;

    @Override
    public Product add(Product product) {
        return productRepository.save(product);
    }

    @Override
    public List<Product> findAll() {
        return productRepository.findAll();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND ));
    }

    @Override
    public void deleteById(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public Product update(Product product) {
        return productRepository.save(product);
    }
}
