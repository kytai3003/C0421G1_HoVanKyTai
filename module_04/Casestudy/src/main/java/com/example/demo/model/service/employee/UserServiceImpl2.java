package com.example.demo.model.service.employee;

import com.example.demo.model.entity.security.User;
import com.example.demo.model.repository.security.IUserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl2 implements IUserService{

    @Autowired
    private IUserRepository iUserRepository;

    @Override
    public List<User> findAll() {
        return this.iUserRepository.findAll();
    }
}
