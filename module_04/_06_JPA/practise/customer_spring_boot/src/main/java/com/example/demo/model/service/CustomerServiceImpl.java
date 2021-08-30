package com.example.demo.model.service;

import com.example.demo.model.bean.Customer;
import com.example.demo.model.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepo iCustomerRepo;

    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepo.findAll();
    }

    @Override
    public Customer findById(Long id) {
        return this.iCustomerRepo.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepo.save(customer);
    }

    @Override
    public void remove(Long id) {
        this.iCustomerRepo.deleteById(id);
    }
}
