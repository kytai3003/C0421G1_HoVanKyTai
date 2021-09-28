package com.example.demo.model.repo;

import com.example.demo.model.entity.TypeProduct;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITypeProductRepo extends JpaRepository<TypeProduct, Integer> {
}
