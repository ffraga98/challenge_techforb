package com.techforb.challenge.entity;


import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;

@Entity
@Table( name = "address" )
public class Address {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;
    
    @Column(nullable = false)
    private String city;

    @Column(nullable = false)
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

    public void update(Address ad){
        if ( ad != null ) {
            if ( ad.city != null && !ad.city.isEmpty() ){
                this.city = ad.city;
            }
            if ( ad.country != null && !ad.country.isEmpty() ){
                this.country = ad.country;
            }
            if ( ad.street != null && !ad.street.isEmpty() ){
                this.street = ad.street ;
            }
        }
    }
}
