package com.example.demo.model.service.service;

import com.example.demo.model.entity.service.Service;
import com.example.demo.model.entity.service.ServiceType;

import java.util.List;
import java.util.Optional;

public interface IServiceTypeService {
    List<ServiceType> findAll();

    Optional<ServiceType> findById(Integer id);

    void save(ServiceType serviceType);

    void remove(Integer id);
}
