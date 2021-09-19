package com.example.demo.model.service.service;

import com.example.demo.model.entity.service.Service;
import com.example.demo.model.repository.service.IServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

@org.springframework.stereotype.Service
public class ServiceServiceImpl implements IServiceService{

    @Autowired
    private IServiceRepository iServiceRepository;

    @Override
    public Page<Service> findAll(Pageable pageable) {
        return this.iServiceRepository.findAll(pageable);
    }

    @Override
    public List<Service> findAll() {
        return this.iServiceRepository.findAll();
    }

    @Override
    public Optional<Service> findById(Integer id) {
        return this.iServiceRepository.findById(id);
    }

    @Override
    public void save(Service service) {
        this.iServiceRepository.save(service);
    }

    @Override
    public void remove(Integer id) {
        this.iServiceRepository.deleteById(id);
    }
}
