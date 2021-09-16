package com.example.demo.model.service.impl;

import com.example.demo.model.bean.Catelogy;
import com.example.demo.model.repository.ICatelogyRepo;
import com.example.demo.model.service.ICatelogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CatelogyServiceImpl implements ICatelogyService {

    @Autowired
    private ICatelogyRepo iCatelogyRepo;

    @Override
    public List<Catelogy> findAll() {
        return this.iCatelogyRepo.findAll();
    }


    @Override
    public Catelogy findById(Integer id) {
        return this.iCatelogyRepo.findById(id).get();
    }

    @Override
    public void save(Catelogy catelogy) {
        this.iCatelogyRepo.save(catelogy);
    }

    @Override
    public void remove(Integer id) {
        this.iCatelogyRepo.deleteById(id);
    }
}
