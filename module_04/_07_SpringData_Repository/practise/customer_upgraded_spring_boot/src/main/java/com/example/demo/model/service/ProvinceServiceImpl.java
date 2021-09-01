package com.example.demo.model.service;

import com.example.demo.model.bean.Province;
import com.example.demo.model.repository.IProvinceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProvinceServiceImpl implements IProvinceService{

    @Autowired
    private IProvinceRepository iProvinceRepository;

    @Override
    public List<Province> findAll() {
        return this.iProvinceRepository.findAll();
    }

    @Override
    public Province findById(Long id) {
        return this.iProvinceRepository.findById(id).get();
    }

    @Override
    public void save(Province province) {
        this.iProvinceRepository.save(province);
    }

    @Override
    public void remove(Long id) {
        this.iProvinceRepository.deleteById(id);
    }
}
