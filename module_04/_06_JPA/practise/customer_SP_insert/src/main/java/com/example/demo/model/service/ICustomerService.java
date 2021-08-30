package com.example.demo.model.service;

import com.example.demo.model.bean.Customer;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ICustomerService {
    List<Customer> findAll();

    void insertWithStoredProcedure(@Param("firstName") String firstName, @Param("lastName") String lastName);
}
