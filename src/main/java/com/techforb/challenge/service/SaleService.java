package com.techforb.challenge.service;

import com.techforb.challenge.dto.command.SaleCDto;
import com.techforb.challenge.dto.query.SaleQDto;
import com.techforb.challenge.entity.Customer;
import com.techforb.challenge.entity.Product;
import com.techforb.challenge.entity.Sale;
import com.techforb.challenge.entity.SalesItem;
import com.techforb.challenge.mapper.Mapper;
import com.techforb.challenge.repository.CustomerRepository;
import com.techforb.challenge.repository.ProductRepository;
import com.techforb.challenge.repository.SaleRepository;
import com.techforb.challenge.repository.SalesItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.Iterator;
import java.util.List;

@Service
public class SaleService implements IService<Sale, SaleCDto,Long> {
    @Autowired
    private SaleRepository saleRepository;

    @Autowired
    private CustomerRepository customerRepository;

    @Autowired
    private ProductRepository productRepository;

    @Autowired
    private SalesItemRepository salesItemRepository;
    @Autowired
    @Qualifier("saleMapper")
    private Mapper<Sale, SaleCDto, SaleQDto> mapper;

    @Override
    public Sale create(SaleCDto sale) {
        Customer customer = customerRepository.findById(sale.getCustomerId()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND ));
        Sale s = mapper.createEntity(sale);
        s.setCustomer(customer);
        Iterator<Long> productIterator = sale.getProductsId().iterator();
        Iterator<Integer> amountIterator = sale.getAmounts().iterator();
        while ( productIterator.hasNext() && amountIterator.hasNext() ){
            Product product = productRepository.findById(productIterator.next()).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
            SalesItem item = s.addItem(product, amountIterator.next()).orElseThrow( () -> new ResponseStatusException(HttpStatus.BAD_REQUEST));
            salesItemRepository.save(item);
            productRepository.save(product);
        }
        return saleRepository.save(s);
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
    public void remove(Long id) {
        saleRepository.deleteById(id);
    }

    @Override
    public Sale update(SaleCDto element) {
        return null;
    }

    public List<Sale> getSalesOfTheDay(SaleCDto sale) {
        return saleRepository.getSalesByDateIs(mapper.createEntity(sale).getDate());
    }

    public List<Sale> getSalesBySupplierId(Long id) {
        return saleRepository.getSalesBySupplier(id);
    }
}
