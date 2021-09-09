package com.example.demo.model.service;

import com.example.demo.model.entity.Customer;
import com.example.demo.model.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepo iCustomerRepo;

    @Override
    public Iterable<Customer> findAll() {
        return this.iCustomerRepo.findAll();
    }

    @Override
    public Optional<Customer> findById(Long id) {
        return this.iCustomerRepo.findById(id);
    }

    @Override
    public Customer save(Customer t) {
        return this.iCustomerRepo.save(t);
    }

    @Override
    public void remove(Long id) {
        this.iCustomerRepo.deleteById(id);
    }
}
