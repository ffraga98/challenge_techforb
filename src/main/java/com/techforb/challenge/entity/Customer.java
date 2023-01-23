package com.techforb.challenge.entity;


import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

import java.util.Set;


@Entity
@Table( name = "customer" )
@SQLDelete(sql = "UPDATE customer SET deleted = true WHERE id = ?")
public class Customer {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String dni;

    @Column(nullable = false)
    private String phone;

    @OneToOne( cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE} )
    @JoinColumn( name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "customer" )
    private Set<Sale> purchases;

    @Column(nullable = false)
    private Boolean deleted = Boolean.FALSE;

    public Customer() {
    }

    public Customer(String name, String cuit, String phone, Address address, Set<Sale> purchases, Boolean deleted) {
        this.name = name;
        this.dni = dni;
        this.phone = phone;
        this.address = address;
        this.purchases = purchases;
        this.deleted = deleted;
    }

    public void setDeleted(Boolean deleted) {
        this.deleted = deleted;
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

    public String getDni() {
        return dni;
    }

    public void setDni(String dni) {
        this.dni = dni;
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

    public void update(Customer c){
        if ( c.name != null && !c.name.isEmpty()){
            this.name = c.name;
        }
        if ( c.dni != null && !c.dni.isEmpty()){
            this.dni = c.dni;
        }
        if ( c.phone != null && !c.phone.isEmpty()){
            this.phone = c.phone;
        }
        if ( c.address != null ){
            this.address.update(c.address);
        }
    }
}
