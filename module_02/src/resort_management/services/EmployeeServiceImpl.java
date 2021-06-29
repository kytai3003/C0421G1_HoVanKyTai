package resort_management.services;

import resort_management.models.Employee;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class EmployeeServiceImpl implements EmployeeService{
    static Scanner sc = new Scanner(System.in);
    public static List<Employee> employees = new ArrayList<>();
    static {
        Employee employee1 = new Employee(1, "Nguyen Van A", "30/03/1993", "Male", "abc@gmail.com", 200123456,
                "123456789", "Receptionist", 5000000, "College");
        Employee employee2 = new Employee(2, "Nguyen Thi B", "20/02/1999", "Female", "def@gmail.com", 200456789,
                "123456789", "Accountant", 7500000, "University");
        Employee employee3 = new Employee(3, "Nguyen Van C", "11/11/2001", "Male", "ijk@gmail.com", 200789123,
                "123456789", "Guard", 4000000, "Intermediate");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
    }

    @Override
    public void displayList() {
        for (Employee a: employees) {
            System.out.println(a);
        }
    }

    @Override
    public void addNew() {
        System.out.println("Input code: ");
        int code = Integer.parseInt(sc.nextLine());
        System.out.println("Input name: ");
        String name = sc.nextLine();
        System.out.println("Input day of birth: ");
        String dayOfBirth = sc.nextLine();
        System.out.println("Input sex: ");
        String sex = sc.nextLine();
        System.out.println("Input email: ");
        String email = sc.nextLine();
        System.out.println("Input ID number: ");
        int idNumber = Integer.parseInt(sc.nextLine());
        System.out.println("Input phone number: ");
        String phone = sc.nextLine();
        System.out.println("Input position: ");
        String position = sc.nextLine();
        System.out.println("Input salary: ");
        double salary = Integer.parseInt(sc.nextLine());
        System.out.println("Input qualification. Choose one: ");
        String[] qualArr = {"University", "College", "Intermediate", "Postgraduated"};
        for (String q: qualArr) {
            System.out.print(q + ", ");
        }
        String qualification = sc.nextLine();
        boolean isExist = false;
        for (int i = 0; i < qualArr.length; i++) {
            if (qualification.equals(qualArr[i])) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            System.out.println("Successful!");
            Employee newEmployee = new Employee(code, name, dayOfBirth, sex, email, idNumber, phone, position, salary, qualification);
            employees.add(newEmployee);
        } else {
            System.err.println("Input qualification false. Please retry.");
        }
    }

    @Override
    public void editEmployee() {
        System.out.println("You chose Employee Editing.");
        System.out.println("Input id: ");
        int input = Integer.parseInt(sc.nextLine());
        boolean isExist = false;
        int index = 0;
        for (int i = 0; i < employees.size(); i++) {
            if (employees.get(i).getCode() == input) {
                isExist = true;
                index = i;
                break;
            }
        }
        if (!isExist) {
            System.err.println("Id not found!");
        } else {

            System.out.println("Choose the property: ");
            System.out.println("1) Edit name");
            System.out.println("2) Edit day of birth");
            System.out.println("3) Edit sex");
            System.out.println("4) Edit email");
            System.out.println("5) Edit ID number");
            System.out.println("6) Edit phone");
            System.out.println("7) Edit position");
            System.out.println("8) Edit salary");
            System.out.println("9) Edit qualification");
            System.out.println("0) Back.");
            int empChoice = Integer.parseInt(sc.nextLine());
            switch (empChoice) {
                case 1:
                    System.out.println("Input new name: ");
                    String newName = sc.nextLine();
                    employees.get(index).setName(newName);
                    break;

                case 2:
                    System.out.println("Input new day of birth: ");
                    String newDob = sc.nextLine();
                    employees.get(index).setDayOfBirth(newDob);
                    break;

                case 3:
                    System.out.println("Input new sex: ");
                    String newSex = sc.nextLine();
                    employees.get(index).setSex(newSex);
                    break;

                case 4:
                    System.out.println("Input new email: ");
                    String newEmail = sc.nextLine();
                    employees.get(index).setEmail(newEmail);
                    break;

                case 5:
                    System.out.println("Input new ID number: ");
                    int newIdNumb = Integer.parseInt(sc.nextLine());
                    employees.get(index).setIdNumber(newIdNumb);
                    break;

                case 6:
                    System.out.println("Input phone number: ");
                    String newPhone = sc.nextLine();
                    employees.get(index).setPhoneNumber(newPhone);
                    break;

                case 7:
                    System.out.println("Input new position: ");
                    String newPos = sc.nextLine();
                    employees.get(index).setPosition(newPos);
                    break;

                case 8:
                    System.out.println("Input new salary: ");
                    double newSalary = Integer.parseInt(sc.nextLine());
                    employees.get(index).setSalary(newSalary);
                    break;

                case 9:
                    String[] qualification = {"University", "College", "Intermediate", "Postgraduate"};
                    System.out.println("Choose new qualification: ");
                    for (int i = 0; i < qualification.length; i++) {
                        System.out.println(i + ") " + qualification[i]);
                    }
                    int choice = Integer.parseInt(sc.nextLine());
                    boolean isLegal = false;
                    while (!isLegal) {
                        if (choice < 0 || choice > 3) {
                            System.err.println("Input false. Please retry!");
                            return;
                        } else {
                            employees.get(index).setQualification(qualification[choice]);
                            isLegal = true;
                        }
                    }
                    break;

                case 0:
                    return;

                default:
                    System.err.println("False input. Please retry.");
            }
        }
    }
}
