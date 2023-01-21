package com.techforb.challenge.entity;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.math.BigDecimal;

@Entity
@Table( name = "sale" )
public class Sale {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;

    @Column
    private LocalDate date;

    @ManyToOne
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private Product product;

    @Column
    private Integer amount;

    @Column
    private BigDecimal totalPrice;

    public Sale() {
    }

    public Sale(LocalDate date, Customer customer, Product product, Integer amount, BigDecimal totalPrice) {
        this.date = date;
        this.customer = customer;
        this.product = product;
        this.amount = amount;
        this.totalPrice = totalPrice;
    }

    public Long getId() {
        return id;
    }

    public LocalDate getDate() {
        return date;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
