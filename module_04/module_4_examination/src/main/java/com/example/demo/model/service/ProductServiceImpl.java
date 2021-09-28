package com.example.demo.model.service;

import com.example.demo.model.entity.Product;
import com.example.demo.model.repo.IProductRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.annotation.Transient;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Date;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements IProductService{

    @Autowired
    private IProductRepo iProductRepo;

    @Override
    public Page<Product> findAll(Pageable pageable) {
        return this.iProductRepo.findAll(pageable);
    }

    @Override
    public List<Product> findAll() {
        return this.iProductRepo.findAll();
    }

    @Override
    public Optional<Product> findById(Integer id) {
        return this.iProductRepo.findById(id);
    }

    @Transactional
    @Override
    public void save(Product product) {
        this.iProductRepo.save(product);
    }

    @Override
    public Page<Product> findAllByDate(Pageable pageable, Date dateFrom, Date dateTo) {
        return this.iProductRepo.findAllByDate(pageable, dateFrom, dateTo);
    }
}
