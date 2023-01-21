package com.techforb.challenge.entity;

import java.util.List;

public class Supplier {
    private Long id;
    private String name;
    private String cuit;
    private String phone;
    private Address address;
    private List<Product> supplied_products;
}
