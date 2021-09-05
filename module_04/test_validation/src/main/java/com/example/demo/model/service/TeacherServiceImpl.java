package com.example.demo.model.service;

import com.example.demo.model.entity.FormTeacher;
import com.example.demo.model.repository.ITeacherRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TeacherServiceImpl implements ITeacherService{

    @Autowired
    private ITeacherRepo iTeacherRepo;

    @Override
    public Page<FormTeacher> findAll(Pageable pageable) {
        return this.iTeacherRepo.findAll(pageable);
    }

    @Override
    public void save(FormTeacher formTeacher) {

    }

    @Override
    public List<FormTeacher> findAll() {
        return this.iTeacherRepo.findAll();
    }
}
