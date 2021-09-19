package com.example.demo.model.service.customer;

import com.example.demo.model.entity.customer.Customer;
import com.example.demo.model.repository.customer.ICustomerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService{

    @Autowired
    private ICustomerRepository iCustomerRepository;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return this.iCustomerRepository.findAll(pageable);
    }

    @Override
    public List<Customer> findAll() {
        return this.iCustomerRepository.findAll();
    }

    @Override
    public Customer findById(Integer id) {
        return this.iCustomerRepository.findById(id).get();
    }

    @Override
    public void save(Customer customer) {
        this.iCustomerRepository.save(customer);
    }

    @Override
    public void remove(Integer id) {
        this.iCustomerRepository.deleteById(id);
    }

    @Override
    public List<Customer> findByCustomerNameIsContaining(String name) {
        return this.iCustomerRepository.findByCustomerNameIsContaining(name);
    }
}
