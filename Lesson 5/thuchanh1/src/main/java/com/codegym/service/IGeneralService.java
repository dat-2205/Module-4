package com.codegym.service;

import java.util.List;

public interface IGeneralService<T> {
    List<T> findAll();

    T find(Long id);

    void save(T t);

    void remove(Long id);
}
