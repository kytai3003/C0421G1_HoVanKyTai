package com.example.demo.model.service.employee;

import com.example.demo.model.entity.employee.Employee;
import com.example.demo.model.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IEmployeeService {
    Page<Employee> findAll(Pageable pageable);

    List<Employee> findAll();

    Optional<Employee> findById(Integer id);

    void save(Employee employee);

    void remove(Integer id);

    List<Employee> findAllByPosition_PositionId(Integer id);

    List<Employee> findAllByEmployeeNameContaining(String name);

    Page<Employee> findAllByEmployeeNameContainingAndPosition_PositionName(Pageable pageable, String name, String positionName);
}
