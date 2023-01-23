package com.techforb.challenge.mapper;

import com.techforb.challenge.dto.command.ProductDTO;
import com.techforb.challenge.entity.Product;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;

@Component("productMapper")
public class ProductMapper implements Mapper<Product, ProductDTO> {
    @Override
    public Product createEntity(ProductDTO productDTO){
        Product p = new Product();

        p.setDescription(productDTO.getDescription());
        p.setName(productDTO.getName());
        p.setPrice(productDTO.getPrice());
        p.setStock(productDTO.getStock());

        return p;
    }

    @Override
    public ProductDTO createDTO(Product product){
        return new ProductDTO();
    }
}
