package com.example.demo.model.service;

import com.example.demo.model.entity.Product;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.query.Param;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

public interface IProductService {
    Page<Product> findAll(Pageable pageable);

    List<Product> findAll();

    Optional<Product> findById(Integer id);

    void save(Product product);

    Page<Product> findAllByDate(Pageable pageable, Date dateFrom, Date dateTo);
}
