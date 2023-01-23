package com.techforb.challenge.entity;

import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.ArrayList;
import java.util.List;

@Entity
@Table( name = "supplier" )
@SQLDelete(sql = "UPDATE supplier SET deleted = true WHERE id = ?")
public class Supplier {

    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String cuit;

    @Column(nullable = false)
    private String phone;

    @OneToOne( cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE} )
    @JoinColumn( name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "supplier")
    private List<Product> supplied_products = new ArrayList<>();

    @Column(nullable = false)
    private Boolean deleted = Boolean.FALSE;

    public Supplier() {
    }

    public Supplier(String name, String cuit, String phone, Address address, List<Product> supplied_products, Boolean deleted) {
        this.name = name;
        this.cuit = cuit;
        this.phone = phone;
        this.address = address;
        this.supplied_products = supplied_products;
        this.deleted = deleted;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getId() {
        return id;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

        public void update(Supplier s){
            if ( s.name != null && !s.name.isEmpty()){
                this.name = s.name;
            }
            if ( s.cuit != null && !s.cuit.isEmpty()){
                this.cuit = s.cuit;
            }
            if ( s.phone != null && !s.phone.isEmpty()){
                this.phone = s.phone;
            }
            if ( s.address != null ){
                this.address.update(s.address);
            }
        }
}
