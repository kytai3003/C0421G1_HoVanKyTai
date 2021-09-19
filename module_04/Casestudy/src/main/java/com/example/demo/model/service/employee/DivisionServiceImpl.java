package com.example.demo.model.service.employee;

import com.example.demo.model.entity.employee.Division;
import com.example.demo.model.repository.employee.IDivisionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DivisionServiceImpl implements IDivisionService{
    @Autowired
    private IDivisionRepository iDivisionRepository;

    @Override
    public List<Division> findAll() {
        return this.iDivisionRepository.findAll();
    }
}
