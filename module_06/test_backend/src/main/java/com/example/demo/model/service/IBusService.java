package com.example.demo.model.service;

import com.example.demo.model.bean.Bus;

import java.util.List;
import java.util.Optional;


public interface IBusService {
    List<Bus> findAll();
    void save(Bus bus);
    void remove(Integer id);
    Optional<Bus> findById(Integer id);
}
