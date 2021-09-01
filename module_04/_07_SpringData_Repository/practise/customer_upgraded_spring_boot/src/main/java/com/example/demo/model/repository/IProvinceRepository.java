package com.example.demo.model.repository;

import com.example.demo.model.bean.Province;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IProvinceRepository extends JpaRepository<Province, Long> {

}
