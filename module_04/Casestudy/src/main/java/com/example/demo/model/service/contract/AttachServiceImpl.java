package com.example.demo.model.service.contract;

import com.example.demo.model.entity.contract.AttachService;
import com.example.demo.model.repository.contract.AttachServiceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class AttachServiceImpl implements IAttachServiceService{

    @Autowired
    private AttachServiceRepository attachServiceRepository;

    @Override
    public List<AttachService> findAll() {
        return this.attachServiceRepository.findAll();
    }
}
