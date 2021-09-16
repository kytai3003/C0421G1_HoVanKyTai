package com.example.demo.model.service;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Catelogy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface ICatelogyService {
    List<Catelogy> findAll();

    Catelogy findById(Integer id);

    void save(Catelogy catelogy);

    void remove(Integer id);
}
