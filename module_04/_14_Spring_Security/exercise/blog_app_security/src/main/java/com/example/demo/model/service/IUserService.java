package com.example.demo.model.service;

import com.example.demo.model.bean.User;

import java.util.List;

public interface IUserService {

    List<User> findAll();
    void save(User user);
    void update(User user);
    User findById(int id);
}
