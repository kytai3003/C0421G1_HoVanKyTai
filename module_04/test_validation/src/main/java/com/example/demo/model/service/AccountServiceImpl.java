package com.example.demo.model.service;

import com.example.demo.model.entity.Account;
import com.example.demo.model.repository.IAccountRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Service
public class AccountServiceImpl implements IAccountService{

    @Autowired
    private IAccountRepo iAccountRepo;

    @Override
    public Page<Account> findAll(Pageable pageable) {
        return this.iAccountRepo.findAll(pageable);
    }

    @Override
    public void save(Account account) {

    }

    @Override
    public List<Account> findAll() {
        return this.iAccountRepo.findAll();
    }
}
