package com.example.demo.model.service;

import com.example.demo.model.entity.FormTeacher;

import java.util.List;

public interface ITeacherService extends IGeneralService<FormTeacher> {
    List<FormTeacher> findAll();
}
