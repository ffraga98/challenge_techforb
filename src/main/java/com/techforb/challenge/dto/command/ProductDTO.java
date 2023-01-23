package com.techforb.challenge.dto.command;

import java.math.BigDecimal;

public class ProductDTO {
    private Long id;
    private String name;
    private String description;
    private BigDecimal price;
    private Integer stock;
    private Long supplierId;

    public ProductDTO() {
    }

    public ProductDTO(Long id, String name, String description, BigDecimal price, Integer stock, Long supplierId) {
        this.id = id;
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.supplierId = supplierId;
    }

    public ProductDTO(String name, String description, BigDecimal price, Integer stock, Long supplierId) {
        this.name = name;
        this.description = description;
        this.price = price;
        this.stock = stock;
        this.supplierId = supplierId;
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

    public Long getSupplierId() {
        return supplierId;
    }

    public void setSupplierId(Long supplierId) {
        this.supplierId = supplierId;
    }
}
