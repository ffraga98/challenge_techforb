package com.techforb.challenge.entity;


import jakarta.persistence.*;

public class Address {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;
    
    @Column
    private String city;

    @Column
    private String country;

    @Column
    private String street;

    public Address() {
    }

    public Address(String city, String country, String street) {
        this.city = city;
        this.country = country;
        this.street = street;
    }

    public Long getId() {
        return id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }
}
