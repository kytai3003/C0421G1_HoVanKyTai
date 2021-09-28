package com.example.demo.model.service;

import com.example.demo.model.entity.TypeProduct;
import com.example.demo.model.repo.ITypeProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TypeProductServiceImpl implements ITypeProductService{

    @Autowired
    private ITypeProductRepo iTypeProductRepo;

    @Override
    public List<TypeProduct> findAll() {
        return this.iTypeProductRepo.findAll();
    }
}
