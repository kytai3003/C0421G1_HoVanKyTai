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



    //    DELIMITER //
//    CREATE PROCEDURE Insert_Customer(IN first_name VARCHAR(255), IN last_name VARCHAR(255))
//    BEGIN
//    INSERT INTO customer(firstName,lastName) VALUES (first_name,last_name);
//    END
//    DELIMITER ;
    @Override
    public void insertWithStoredProcedure(String firstName, String lastName) {
        this.iCustomerRepo.insertWithStoredProcedure(firstName, lastName);

    }
}
