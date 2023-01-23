package com.techforb.challenge.service;

import com.techforb.challenge.dto.command.ProductDTO;
import com.techforb.challenge.dto.externApi.ProductApi;
import com.techforb.challenge.entity.Product;
import com.techforb.challenge.entity.Supplier;
import com.techforb.challenge.mapper.Mapper;
import com.techforb.challenge.repository.ProductRepository;
import com.techforb.challenge.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProductService implements IService<Product, ProductDTO, Long> {
    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    @Qualifier("ApiMapper")
    private Mapper<Product,ProductApi, ProductApi > apiMapper;
    @Autowired
    @Qualifier("productMapper")
    private Mapper<Product,ProductDTO, ProductDTO> mapper;
    @Override
    public Product create(ProductDTO element) {
        Long id = element.getId();
        Long supplierId = element.getSupplierId();

        Product product = null;
        if ( id != null ) {
            product = this.restore(id);
        }else{
            Supplier s = supplierRepository.findById( supplierId ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            product = mapper.createEntity(element);
            product.setSupplier(s);
            product = productRepository.save(product);
        }
        return product;
    }

    private Product restore( Long id ) {
        Product c = productRepository.findByIdAndDeletedIsTrue( id ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        c.setDeleted(Boolean.FALSE);
        return productRepository.save(c);
    }
    @Override
    public List<Product> findAll() {
        return productRepository.findAllByDeletedIsFalseAndSupplier_DeletedIsFalse();
    }

    @Override
    public Product findById(Long id) {
        return productRepository.findById(id).orElseThrow( () -> new ResponseStatusException(HttpStatus.NOT_FOUND ));
    }

    @Override
    public void remove(Long id) {
        productRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        productRepository.deleteById(id);
    }

    @Override
    public Product update(ProductDTO p) {
        Long id = p.getId();
        //Agregar excepción de que debe dar un ID para poder actualizar.
        Product product = this.findById(id);
        product.update(mapper.createEntity(p));
        return productRepository.save(product);
    }

    public List<Product> listProductsWithStockLowerThan(Long stock) {
        return productRepository.findByStockLessThanEqual(stock);
    }

    public List<Product> formatListOfProducts(List<ProductApi> products) {
        return products.stream().map( p -> apiMapper.createEntity(p)).collect(Collectors.toList());
    }
}
