package com.example.demo.model.service.customer;

import com.example.demo.model.entity.customer.CustomerType;

import java.util.List;

public interface ICustomerTypeService {
    List<CustomerType> findAll();
}
