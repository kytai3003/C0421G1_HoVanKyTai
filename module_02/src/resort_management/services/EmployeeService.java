package resort_management.services;

import resort_management.models.Employee;

import java.util.ArrayList;

public interface EmployeeService{
    void displayList(ArrayList<Employee> arrayList);
    void addNew();
    void editEmployee();
}
