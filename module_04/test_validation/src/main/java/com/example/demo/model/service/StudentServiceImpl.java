package com.example.demo.model.service;

import com.example.demo.model.entity.Student;
import com.example.demo.model.repository.IStudentRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class StudentServiceImpl implements IStudentService {

    @Autowired
    private IStudentRepo iStudentRepo;

    @Override
    public Page<Student> findAll(Pageable pageable) {
        return this.iStudentRepo.findAll(pageable);
    }

    @Override
    public void save(Student student) {
        this.iStudentRepo.save(student);
    }

    @Override
    public Optional<Student> findById(int id) {
        return this.iStudentRepo.findById(id);
    }
}
