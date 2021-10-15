package com.example.demo.model.repository;

import com.example.demo.model.bean.Bus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBusRepository extends JpaRepository<Bus, Integer> {
}
