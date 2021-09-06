package com.example.demo.model.service;

import com.example.demo.model.entity.RegisterForm;

import java.util.List;

public interface IRegisterFormService {
    void save(RegisterForm registerForm);

    List<RegisterForm> findAll();
}
