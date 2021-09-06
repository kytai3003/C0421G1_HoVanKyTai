package com.example.demo.model.service;

import com.example.demo.model.entity.RentCode;
import com.example.demo.model.repo.ICodeRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CodeServiceImpl implements ICodeService{

    @Autowired
    private ICodeRepo iCodeRepo;

    @Override
    public List<RentCode> findAll() {
        return this.iCodeRepo.findAll();
    }

    @Override
    public void save(RentCode code) {
        this.iCodeRepo.save(code);
    }

    @Override
    public RentCode findById(int id) {
        return this.iCodeRepo.findById(id).get();
    }

    @Override
    public void remove(int id) {
        this.iCodeRepo.deleteById(id);
    }
}
