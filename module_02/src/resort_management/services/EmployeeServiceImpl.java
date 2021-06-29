package resort_management.services;

import resort_management.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{
    static Scanner sc = new Scanner(System.in);

    static {
        List<Employee> employees = new ArrayList<>();
        Employee employee1 = new Employee(1, "Nguyen Van A", "30/03/1993", "Male", "abc@gmail.com", 200123456,
                123456789, "Receptionist", 5000000, "College");
        Employee employee2 = new Employee(2, "Nguyen Thi B", "20/02/1999", "Female", "def@gmail.com", 200456789,
                123456789, "Accountant", 7500000, "University");
        Employee employee3 = new Employee(3, "Nguyen Van C", "11/11/2001", "Male", "ijk@gmail.com", 200789123,
                123456789, "Guard", 4000000, "Intermediate");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }


    @Override
    public void displayList(ArrayList<Employee> arrayList) {
        for (Employee a: arrayList) {
            System.out.println(a);
        }
    }

    @Override
    public void addNew() {
        Employee newEmp = new Employee();
        System.out.println("Input code: ");
        int code = sc.nextInt();
        System.out.println("Input name: ");
        String name = sc.next();
    }

    @Override
    public void editEmployee() {

    }
}
