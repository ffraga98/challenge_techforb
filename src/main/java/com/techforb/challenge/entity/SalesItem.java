package com.techforb.challenge.entity;

import jakarta.persistence.*;

import java.math.BigDecimal;

@Entity
@Table( name = "sales_item" )
public class SalesItem {
    @Id
    @GeneratedValue( strategy = GenerationType.SEQUENCE )
    private Long id;

    @Column(nullable = false)
    private Integer amount;

    @OneToOne( cascade = {CascadeType.PERSIST, CascadeType.REFRESH, CascadeType.MERGE} )
    @JoinColumn( name = "product_id", referencedColumnName = "id")
    private Product product;

    public SalesItem() {
    }

    public Integer getAmount() {
        return amount;
    }

    public SalesItem(Integer amount, Product product) {
        this.amount = amount;
        this.product = product;
    }

    public Long getId() {
        return id;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public BigDecimal computePrice() {
        return product.getPrice().multiply(BigDecimal.valueOf(amount));
    }
}
