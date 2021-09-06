package com.example.demo.model.service;
import com.example.demo.model.entity.RentCode;

import java.util.List;

public interface ICodeService {
    List<RentCode> findAll();

    void save(RentCode code);

    RentCode findById(int id);

    void remove(int id);
}
