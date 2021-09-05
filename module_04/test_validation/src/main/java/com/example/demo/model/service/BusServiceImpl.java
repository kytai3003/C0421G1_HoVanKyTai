package com.example.demo.model.service;

import com.example.demo.model.entity.SchoolBus;
import com.example.demo.model.repository.IBusRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BusServiceImpl implements IBusService{

    @Autowired
    private IBusRepo iBusRepo;

    @Override
    public Page<SchoolBus> findAll(Pageable pageable) {
        return this.iBusRepo.findAll(pageable);
    }

    @Override
    public void save(SchoolBus schoolBus) {

    }

    @Override
    public List<SchoolBus> findAll() {
        return this.iBusRepo.findAll();
    }
}
