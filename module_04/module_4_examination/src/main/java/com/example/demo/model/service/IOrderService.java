package com.example.demo.model.service;

import com.example.demo.model.entity.OrderProduct;

import java.util.List;

public interface IOrderService {
    List<OrderProduct> findAll();
}
