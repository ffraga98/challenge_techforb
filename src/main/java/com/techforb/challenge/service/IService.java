package com.techforb.challenge.service;

import com.techforb.challenge.entity.Supplier;

import java.util.List;
import java.util.Optional;

public interface IService<T,U> {
    List<Supplier> findAll();
    Optional<T> findById(U id);
    void deleteById(U id);
    Optional<T> update(T element);
}
