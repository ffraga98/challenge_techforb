package com.techforb.challenge.dto.command;

import java.util.List;

public class SaleCDto {
    private Long id;
    private String date;
    private Long customerId;
    private List<Long> productsId;
    private List<Integer> amounts;

    public SaleCDto() {
    }

    public SaleCDto(Long id, String date, Long customerId, List<Long> productsId, List<Integer> amounts) {
        this.id = id;
        this.date = date;
        this.customerId = customerId;
        this.productsId = productsId;
        this.amounts = amounts;
    }

    public SaleCDto(String date, Long customerId, List<Long> productsId, List<Integer> amounts) {
        this.date = date;
        this.customerId = customerId;
        this.productsId = productsId;
        this.amounts = amounts;
    }

    public Long getId() {
        return id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Long getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Long customerId) {
        this.customerId = customerId;
    }

    public List<Long> getProductsId() {
        return productsId;
    }

    public void setProductsId(List<Long> productsId) {
        this.productsId = productsId;
    }

    public List<Integer> getAmounts() {
        return amounts;
    }

    public void setAmounts(List<Integer> amounts) {
        this.amounts = amounts;
    }
}
