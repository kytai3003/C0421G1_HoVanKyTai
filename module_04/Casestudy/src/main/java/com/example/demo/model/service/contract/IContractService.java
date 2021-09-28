package com.example.demo.model.service.contract;


import com.example.demo.model.entity.contract.Contract;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IContractService {
    Page<Contract> findAll(Pageable pageable);

    void save(Contract contract);

    void remove(Integer id);

    List<Contract> findAll();
}
