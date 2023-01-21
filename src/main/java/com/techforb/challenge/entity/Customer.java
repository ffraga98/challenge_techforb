package com.techforb.challenge.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.Set;


@Entity
@Table( name = "customer" )
public class Customer {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;

    @Column
    private String name;

    @Column
    private String cuit;

    @Column
    private String phone;

    @OneToOne( cascade = CascadeType.ALL )
    @JoinColumn( name = "address_id", referencedColumnName = "id")
    private Address address;


    @OneToMany( mappedBy = "customer" )
    @JsonIgnore
    private Set<Sale> purchases;

    public Customer() {
    }

    public Customer(String name, String cuit, String phone, Address address, Set<Sale> purchases) {
        this.name = name;
        this.cuit = cuit;
        this.phone = phone;
        this.address = address;
        this.purchases = purchases;
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

    public Set<Sale> getPurchases() {
        return purchases;
    }

    public void setPurchases(Set<Sale> purchases) {
        this.purchases = purchases;
    }
}
