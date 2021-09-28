package com.example.demo.model.service;

import com.example.demo.model.entity.OrderProduct;
import com.example.demo.model.repo.IOrderRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class OrderServiceImpl implements IOrderService{

    @Autowired
    private IOrderRepo iOrderRepo;

    @Override
    public List<OrderProduct> findAll() {
        return this.iOrderRepo.findAll();
    }
}
