package com.techforb.challenge.service;

import com.techforb.challenge.entity.Supplier;
import com.techforb.challenge.entity.Supplier;
import com.techforb.challenge.repository.AddressRepository;
import com.techforb.challenge.repository.SupplierRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;

@Service
public class SupplierService implements IService<Supplier,Supplier, Long> {
    @Autowired
    private SupplierRepository supplierRepository;

    @Autowired
    private AddressRepository addressRepository;

    @Override
    public Supplier create(Supplier element) {
        Supplier supplier = null;
        Long id = element.getId();
        if ( id != null ) {
            supplier = this.restore(id);
        }else{
            supplier = supplierRepository.save(element);
        }
        return supplier;
    }

    private Supplier restore( Long id ) {
        Supplier c = supplierRepository.findById( id ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
        c.setDeleted(Boolean.FALSE);
        supplierRepository.save(c);
        return supplierRepository.findByIdWithAvailableProducts( id ).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public List<Supplier> findAll() {
        return supplierRepository.findAllWithAvailableProducts();
    }

    @Override
    public Supplier findById(Long id) {
        return supplierRepository.findById(id).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND));
    }

    @Override
    public void remove(Long id) {
        supplierRepository.deleteById(id);
    }

    @Override
    public Supplier update(Supplier element) {
        Long id = element.getId();
        //Agregar excepción de que debe dar un ID para poder actualizar.
        Supplier supplier = this.findById(id);
        supplier.update(element);
        addressRepository.save(supplier.getAddress());
        return supplierRepository.save(supplier);
    }

}
