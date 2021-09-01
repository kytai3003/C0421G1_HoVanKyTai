package com.example.demo.model.service;

import com.example.demo.model.bean.Customer;
import com.example.demo.model.bean.Province;

import java.util.List;

public interface IProvinceService {
    List<Province> findAll();

    Province findById(Long id);

    void save(Province province);

    void remove(Long id);
}
