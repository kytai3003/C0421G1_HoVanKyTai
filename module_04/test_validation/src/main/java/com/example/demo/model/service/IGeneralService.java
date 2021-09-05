package com.example.demo.model.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IGeneralService<T> {
    Page<T> findAll(Pageable pageable);

    void save(T t);
}
