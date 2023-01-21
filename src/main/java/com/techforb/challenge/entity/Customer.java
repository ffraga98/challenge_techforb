package com.techforb.challenge.entity;


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

    @OneToOne
    @JoinColumn( name = "address_id", referencedColumnName = "id")
    private Address address;

    @OneToMany
    @JoinColumn( name = "customer" )
    private Set<Sale> purchases;
}
