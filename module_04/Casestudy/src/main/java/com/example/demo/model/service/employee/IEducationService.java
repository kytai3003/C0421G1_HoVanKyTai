package com.example.demo.model.service.employee;

import com.example.demo.model.entity.employee.EducationDegree;

import java.util.List;

public interface IEducationService {

    List<EducationDegree> findAll();
}
