package com.example.demo.model.service;

import com.example.demo.model.bean.Customer;
import com.example.demo.model.bean.Province;
import com.example.demo.model.repository.ICustomerRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CustomerServiceImpl implements ICustomerService {

    @Autowired
    private ICustomerRepo iCustomerRepo;

    @Override
    public Page<Customer> findAll(Pageable pageable) {
        return iCustomerRepo.findAll(pageable);
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

    @Override
    public Iterable<Customer> findAllByProvince(Province province) {
        return this.iCustomerRepo.findAllByProvince(province);
    }

    @Override
    public Page<Customer> findAllByFirstNameContaining(String firstname, Pageable pageable) {
        return this.iCustomerRepo.findAllByFirstNameContaining(firstname, pageable);
    }
}
