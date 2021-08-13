package model.service.impl;

import model.bean.Employee;
import model.repository.IEmployeeRepository;
import model.repository.impl.EmployeeRepositoryImpl;
import model.service.IEmployeeService;
import java.sql.SQLException;
import java.util.List;

public class EmployeeServiceImpl implements IEmployeeService {

    IEmployeeRepository iEmployeeRepository = new EmployeeRepositoryImpl();

    @Override
    public void addNewEmployee(Employee employee) throws SQLException {
        this.iEmployeeRepository.addNewEmployee(employee);
    }

    @Override
    public Employee selectEmployee(int id) {
        return this.iEmployeeRepository.selectEmployee(id);
    }

    @Override
    public List<Employee> selectAllEmployee() {
        return this.iEmployeeRepository.selectAllEmployee();
    }

    @Override
    public boolean deleteEmployee(int id) throws SQLException {
        return this.iEmployeeRepository.deleteEmployee(id);
    }

    @Override
    public boolean updateEmployee(Employee employee) throws SQLException {
        return this.iEmployeeRepository.updateEmployee(employee);
    }

    @Override
    public List<Employee> searchByName(String name) {
        return this.iEmployeeRepository.searchByName(name);
    }
}
