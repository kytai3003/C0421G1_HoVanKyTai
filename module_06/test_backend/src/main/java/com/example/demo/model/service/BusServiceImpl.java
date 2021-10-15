package com.example.demo.model.service;

import com.example.demo.model.bean.Bus;
import com.example.demo.model.repository.IBusRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class BusServiceImpl implements IBusService{

    @Autowired
    private IBusRepository iBusRepository;

    @Override
    public List<Bus> findAll() {
        return this.iBusRepository.findAll();
    }

    @Override
    public void save(Bus bus) {
        this.iBusRepository.save(bus);
    }

    @Override
    public void remove(Integer id) {
        this.iBusRepository.deleteById(id);
    }

    @Override
    public Optional<Bus> findById(Integer id) {
        return this.iBusRepository.findById(id);
    }
}
