package com.example.demo.model.service.employee;

import com.example.demo.model.entity.security.User;

import java.util.List;

public interface IUserService {
    List<User> findAll();
}
