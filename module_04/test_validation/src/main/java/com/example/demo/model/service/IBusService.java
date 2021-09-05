package com.example.demo.model.service;

import com.example.demo.model.entity.SchoolBus;

import java.util.List;

public interface IBusService extends IGeneralService<SchoolBus> {
    List<SchoolBus> findAll();
}
