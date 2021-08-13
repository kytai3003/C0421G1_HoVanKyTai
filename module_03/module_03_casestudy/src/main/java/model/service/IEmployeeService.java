package model.service;

import model.bean.Employee;

import java.sql.SQLException;
import java.util.List;

public interface IEmployeeService {
    void addNewEmployee(Employee employee) throws SQLException;

    Employee selectEmployee(int id);

    List<Employee> selectAllEmployee();

    boolean deleteEmployee(int id) throws SQLException;

    boolean updateEmployee(Employee employee) throws SQLException;

    List<Employee> searchByName(String name);
}
