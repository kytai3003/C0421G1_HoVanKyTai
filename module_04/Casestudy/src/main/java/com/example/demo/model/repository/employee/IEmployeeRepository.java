package com.example.demo.model.repository.employee;

import com.example.demo.model.entity.employee.Employee;
import com.example.demo.model.entity.employee.Position;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IEmployeeRepository extends JpaRepository<Employee, Integer> {

    List<Employee> findAllByEmployeeNameContaining(String name);

    List<Employee> findAllByPosition_PositionId(Integer id);

    @Query(value= "select * from employee e join position p on e.position_id = p.position_id " +
            "where e.employee_name like :employeeName and p.position_name like :positionName",
            nativeQuery = true)
    Page<Employee> findAllByEmployeeNameContainingAndPosition_PositionName(Pageable pageable, @Param("employeeName") String employeeName,@Param("positionName") String positionName);
}
