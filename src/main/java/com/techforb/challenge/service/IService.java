package com.techforb.challenge.service;

import com.techforb.challenge.entity.Customer;

import java.util.List;

public interface IService<T,U> {

    T add(T element);
    List<T> findAll();
    T findById(U id);
    void deleteById(U id);
    T update(T element);
}
