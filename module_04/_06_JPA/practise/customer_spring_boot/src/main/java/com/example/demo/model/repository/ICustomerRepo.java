package com.example.demo.model.repository;

import com.example.demo.model.bean.Customer;
import org.springframework.data.jpa.repository.JpaRepository;


public interface ICustomerRepo extends JpaRepository<Customer, Long> {

}
