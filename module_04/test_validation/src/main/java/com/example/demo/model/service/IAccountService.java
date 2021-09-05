package com.example.demo.model.service;

import com.example.demo.model.entity.Account;

import java.util.List;

public interface IAccountService extends IGeneralService<Account> {
    List<Account> findAll();
}
