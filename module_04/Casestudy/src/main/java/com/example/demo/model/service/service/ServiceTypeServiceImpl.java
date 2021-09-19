package com.example.demo.model.service.service;

import com.example.demo.model.entity.service.ServiceType;
import com.example.demo.model.repository.service.IServiceTypeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ServiceTypeServiceImpl implements IServiceTypeService{

    @Autowired
    private IServiceTypeRepository iServiceTypeRepository;

    @Override
    public List<ServiceType> findAll() {
        return this.iServiceTypeRepository.findAll();
    }

    @Override
    public Optional<ServiceType> findById(Integer id) {
        return Optional.empty();
    }

    @Override
    public void save(ServiceType serviceType) {

    }

    @Override
    public void remove(Integer id) {

    }
}
