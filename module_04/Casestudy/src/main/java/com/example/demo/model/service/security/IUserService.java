package com.example.demo.model.service.security;

import com.example.demo.model.entity.security.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    void save(User user);
    void update(User user);
    User findById(int id);
}
