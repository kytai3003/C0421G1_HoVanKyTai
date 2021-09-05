package com.example.demo.model.service;

import com.example.demo.model.entity.Student;

import java.util.Optional;

public interface IStudentService extends IGeneralService<Student> {

    Optional<Student> findById(int id);
}
