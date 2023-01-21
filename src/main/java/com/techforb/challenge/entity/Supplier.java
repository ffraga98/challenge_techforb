package com.techforb.challenge.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table( name = "supplier" )
public class Supplier {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;

    @Column
    private String name;

    @Column
    private String cuit;

    @Column
    private String phone;

    @OneToOne
    @JoinColumn( name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany
    @JoinColumn( name = "supplier_id" )
    private List<Product> supplied_products;

    public Supplier() {
    }

    public Supplier(String name, String cuit, String phone, Address address, List<Product> supplied_products) {
        this.name = name;
        this.cuit = cuit;
        this.phone = phone;
        this.address = address;
        this.supplied_products = supplied_products;
    }

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCuit() {
        return cuit;
    }

    public void setCuit(String cuit) {
        this.cuit = cuit;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public List<Product> getSupplied_products() {
        return supplied_products;
    }

    public void setSupplied_products(List<Product> supplied_products) {
        this.supplied_products = supplied_products;
    }
}
