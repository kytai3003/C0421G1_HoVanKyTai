package com.example.demo.model.service.impl;

import com.example.demo.model.bean.User;
import com.example.demo.model.repository.IUserRepository;
import com.example.demo.model.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements IUserService {

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return this.iUserRepository.findAll();
    }

    @Override
    public void save(User user) {

    }

    @Override
    public void update(User user) {

    }

    @Override
    public User findById(int id) {
        return null;
    }
}
