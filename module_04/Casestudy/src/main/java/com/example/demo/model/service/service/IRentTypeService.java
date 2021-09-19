package com.example.demo.model.service.service;

import com.example.demo.model.entity.service.RentType;
import java.util.List;
import java.util.Optional;

public interface IRentTypeService {

    List<RentType> findAll();

    Optional<RentType> findById(Integer id);

    void save(RentType rentType);

    void remove(Integer id);
}
