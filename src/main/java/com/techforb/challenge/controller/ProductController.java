package com.techforb.challenge.controller;

import com.techforb.challenge.dto.command.ProductDTO;
import com.techforb.challenge.dto.externApi.ProductApi;
import com.techforb.challenge.entity.Product;
import com.techforb.challenge.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/product")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping
    public List<Product> findAll() {
        return productService.findAll();
    }

    @PostMapping("/")
    public Product add(@RequestBody ProductDTO product) {
        return productService.create(product);
    }

    @GetMapping("/{id}")
    public Product findById(@PathVariable Long id) {
        return productService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteById(@PathVariable Long id) {
        productService.remove(id);
    }

    @GetMapping("/")
    public List<Product> stockLowerThan(@RequestParam("stock") Long stock) {
        return productService.listProductsWithStockLowerThan(stock);
    }

    @GetMapping("/format")
    public List<Product> formatListOfProducts(@RequestBody List<ProductApi> products) {
        return productService.formatListOfProducts(products);
    }
    @PutMapping("/")
    public Product update(@RequestBody ProductDTO product) {
        return productService.update(product);

    }
}