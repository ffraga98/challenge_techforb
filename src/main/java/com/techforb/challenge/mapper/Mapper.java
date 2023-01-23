package com.techforb.challenge.mapper;

public interface Mapper<E,C,Q> {
    E createEntity(C dto);
    Q createDTO(E entity);
}
