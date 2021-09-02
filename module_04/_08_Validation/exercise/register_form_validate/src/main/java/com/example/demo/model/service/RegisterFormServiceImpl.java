package com.example.demo.model.service;

import com.example.demo.model.entity.RegisterForm;
import com.example.demo.model.repository.IRegisterFormRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class RegisterFormServiceImpl implements IRegisterFormService{

    @Autowired
    private IRegisterFormRepo iRegisterFormRepo;

    @Override
    public void save(RegisterForm registerForm) {
        this.iRegisterFormRepo.save(registerForm);
    }
}
