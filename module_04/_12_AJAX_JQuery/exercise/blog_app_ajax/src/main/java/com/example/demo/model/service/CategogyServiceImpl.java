package com.example.demo.model.service;

import com.example.demo.model.bean.Categogy;
import com.example.demo.model.repository.ICategogyRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategogyServiceImpl implements ICategogyService {

    @Autowired
    private ICategogyRepo iCategogyRepo;

    @Override
    public List<Categogy> findAll() {
        return this.iCategogyRepo.findAll();
    }


    @Override
    public Categogy findById(Integer id) {
        return this.iCategogyRepo.findById(id).get();
    }

    @Override
    public void save(Categogy categogy) {
        this.iCategogyRepo.save(categogy);
    }

    @Override
    public void remove(Integer id) {
        this.iCategogyRepo.deleteById(id);
    }
}
