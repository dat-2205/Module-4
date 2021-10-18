package com.codegym.repository;

import com.codegym.model.Music;

import java.util.List;

public interface IGeneralRepository<T>{
    List<T> findAll();

    T find(Long id);

    void save(T t);

    void remove(Long id);
}
