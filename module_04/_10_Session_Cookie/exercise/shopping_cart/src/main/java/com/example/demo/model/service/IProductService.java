package com.example.demo.model.service;

import com.example.demo.model.entity.Product;

import java.util.List;
import java.util.Optional;

public interface IProductService {

    List<Product> findAll();

    Optional<Product> findById(Long id);

    void save(Product product);
}
