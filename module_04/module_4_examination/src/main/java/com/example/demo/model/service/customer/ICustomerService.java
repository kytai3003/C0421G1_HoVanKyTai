package com.example.demo.model.service.customer;

import com.example.demo.model.entity.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ICustomerService {

    Page<Customer> findAll(Pageable pageable);

    List<Customer> findAll();

    Customer findById(Integer id);

    void save(Customer customer);

    void remove(Integer id);

    List<Customer> findByCustomerNameIsContaining(String name);
}
