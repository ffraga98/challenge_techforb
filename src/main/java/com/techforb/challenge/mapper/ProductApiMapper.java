package com.techforb.challenge.mapper;

import com.techforb.challenge.dto.command.ProductDTO;
import com.techforb.challenge.dto.externApi.ProductApi;
import com.techforb.challenge.entity.Product;
import org.springframework.stereotype.Component;

@Component("ApiMapper")
public class ProductApiMapper implements Mapper<Product, ProductApi, ProductApi> {
    @Override
    public Product createEntity(ProductApi api){
        Product p = new Product();
        p.setPrice(api.getProductPrice());
        p.setStock(api.getProductQuantity());
        p.setName(api.getProductName());
        p.setDescription(api.getProductDescription());

        return p;
    }

    @Override
    public ProductApi createDTO(Product product){
        return new ProductApi();
    }
}
