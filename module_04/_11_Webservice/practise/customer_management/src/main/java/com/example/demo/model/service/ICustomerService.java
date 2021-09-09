package com.example.demo.model.service;

import com.example.demo.model.entity.Customer;

import java.util.Optional;

public interface ICustomerService {

    Iterable<Customer> findAll();

    Optional<Customer> findById(Long id);

    Customer save(Customer t);

    void remove(Long id);
}
