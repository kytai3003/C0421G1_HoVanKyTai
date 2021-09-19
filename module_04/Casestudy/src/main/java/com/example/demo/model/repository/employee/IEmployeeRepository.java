package com.example.demo.model.repository.employee;

import com.example.demo.model.entity.employee.Employee;
import com.example.demo.model.entity.employee.Position;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByEmployeeNameContaining(String name);

    List<Employee> findAllByPosition_PositionId(Integer id);

    List<Employee> findAllByEmployeeNameContainingAndPosition_PositionId(String name, Integer id);
}
