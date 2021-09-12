package com.example.demo.model.service;

import com.example.demo.model.bean.Categogy;

import java.util.List;

public interface ICategogyService {
    List<Categogy> findAll();

    Categogy findById(Integer id);

    void save(Categogy categogy);

    void remove(Integer id);
}
