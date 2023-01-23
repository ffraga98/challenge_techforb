package com.techforb.challenge.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.SQLDelete;
import org.hibernate.annotations.Where;

import java.math.BigDecimal;

@Entity
@Table( name = "product")
@SQLDelete(sql = "UPDATE product SET deleted = true WHERE id = ?")
public class Product {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String description;

    @Column(nullable = false)
    private BigDecimal price;

    @Column(nullable = false)
    private Integer stock;

    @Column(nullable = false)
    private Boolean deleted = Boolean.FALSE;

    @ManyToOne( fetch = FetchType.LAZY)
    @JoinColumn(name = "supplier_id", nullable = false)
    @JsonIgnore
    private Supplier supplier;

    public Product() {
    }

    public Product(String name, String description, BigDecimal price, Integer stock, Boolean deleted) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.deleted = deleted;
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

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Supplier getSupplier() {
        return supplier;
    }

    public void setSupplier(Supplier supplier) {
        this.supplier = supplier;
    }
           public void update(Product p){
            if ( p.name != null && !p.name.isEmpty()){
                this.name = p.name;
            }
               if ( p.description != null && !p.description.isEmpty()){
                   this.description= p.description;
               }
               if ( p.price!= null ){
                   this.price = p.price;
               }

               if ( p.stock != null ){
                   this.stock = p.stock;
               }
        }

    public Boolean purchase(Integer amount) {
        Boolean result = this.hasStock(amount);
        if( result ){
            this.stock -= amount;
        }
        return result;
    }

    private Boolean hasStock(Integer amount) {
        return stock >= amount;
    }
}
