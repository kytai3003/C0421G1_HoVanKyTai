package com.example.demo.model.repository;

import com.example.demo.model.bean.Destination;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IDestinationRepository extends JpaRepository<Destination, Integer> {
}
