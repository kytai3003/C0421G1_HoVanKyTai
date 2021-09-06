package com.example.demo.model.repo;

import com.example.demo.model.entity.RentCode;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICodeRepo extends JpaRepository<RentCode, Integer> {
}
