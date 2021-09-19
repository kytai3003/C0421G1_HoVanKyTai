package com.example.demo.model.service.service;
import com.example.demo.model.entity.service.Service;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IServiceService  {
    Page<Service> findAll(Pageable pageable);

    List<Service> findAll();

    Optional<Service> findById(Integer id);

    void save(Service service);

    void remove(Integer id);
}
