package com.example.demo.model.repository;

import com.example.demo.model.entity.FormTeacher;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITeacherRepo extends JpaRepository<FormTeacher, Integer> {
}
