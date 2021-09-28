package com.example.demo.model.service.employee;

import com.example.demo.model.entity.employee.Employee;
import com.example.demo.model.entity.employee.Position;
import com.example.demo.model.repository.employee.IEmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class EmployeeServiceImpl implements IEmployeeService{

    @Autowired
    private IEmployeeRepository iEmployeeRepository;

    @Override
    public Page<Employee> findAll(Pageable pageable) {
        return this.iEmployeeRepository.findAll(pageable);
    }

    @Override
    public List<Employee> findAll() {
        return this.iEmployeeRepository.findAll();
    }

    @Override
    public Optional<Employee> findById(Integer id) {
        return this.iEmployeeRepository.findById(id);
    }

    @Override
    public void save(Employee employee) {
        this.iEmployeeRepository.save(employee);
    }

    @Override
    public void remove(Integer id) {
        this.iEmployeeRepository.deleteById(id);
    }

    @Override
    public List<Employee> findAllByPosition_PositionId(Integer id) {
        return this.iEmployeeRepository.findAllByPosition_PositionId(id);
    }

    @Override
    public List<Employee> findAllByEmployeeNameContaining(String name) {
        return this.iEmployeeRepository.findAllByEmployeeNameContaining(name);
    }

    @Override
    public Page<Employee> findAllByEmployeeNameContainingAndPosition_PositionName(Pageable pageable, String name, String positionName) {
        return this.iEmployeeRepository.findAllByEmployeeNameContainingAndPosition_PositionName(pageable,"%" + name + "%","%" +positionName+ "%");
    }
}
