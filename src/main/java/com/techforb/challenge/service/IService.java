package com.techforb.challenge.service;

import java.util.List;

public interface IService<T,R,U> {

    T create(R dto);
    List<T> findAll();
    T findById(U id);
    void remove(U id);
    T update(R element);
}
