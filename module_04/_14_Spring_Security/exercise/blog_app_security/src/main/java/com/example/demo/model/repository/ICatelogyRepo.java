package com.example.demo.model.repository;

import com.example.demo.model.bean.Catelogy;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ICatelogyRepo extends JpaRepository<Catelogy, Integer> {
}
