package com.example.demo.model.service.employee;

import com.example.demo.model.entity.employee.EducationDegree;
import com.example.demo.model.repository.employee.IEducationRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class EducationServiceImpl implements IEducationService{

    @Autowired
    private IEducationRepository iEducationRepository;

    @Override
    public List<EducationDegree> findAll() {
        return this.iEducationRepository.findAll();
    }
}
