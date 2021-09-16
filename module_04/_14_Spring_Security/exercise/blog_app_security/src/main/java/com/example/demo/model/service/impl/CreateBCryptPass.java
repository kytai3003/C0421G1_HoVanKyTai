package com.example.demo.model.service.impl;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class CreateBCryptPass {
    public static void main(String[] args) {
        BCryptPasswordEncoder bCryptPasswordEncoder = new BCryptPasswordEncoder();
        System.err.println(bCryptPasswordEncoder.encode("2"));
    }
}
