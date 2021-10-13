package com.codegym.service;

import com.codegym.model.Customer;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    Customer find(int id);

    void save (Customer customer);

    boolean update(int id, Customer customer);

    boolean remove(int id);
}
