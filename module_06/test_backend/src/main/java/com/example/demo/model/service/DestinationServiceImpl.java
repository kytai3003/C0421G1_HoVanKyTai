package com.example.demo.model.service;

import com.example.demo.model.bean.Destination;
import com.example.demo.model.repository.IDestinationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DestinationServiceImpl implements IDestinationService{

    @Autowired
    private IDestinationRepository iDestinationRepository;

    @Override
    public List<Destination> findAll() {
        return this.iDestinationRepository.findAll();
    }
}
