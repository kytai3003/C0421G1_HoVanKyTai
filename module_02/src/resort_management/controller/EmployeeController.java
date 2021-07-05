package resort_management.controller;

import resort_management.services.EmployeeServiceImpl;

import java.util.Scanner;

public class EmployeeController {
    static EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
    static Scanner sc = new Scanner(System.in);
    public static void employeeFunction() {
            try {
                System.out.println("You chose Employee Management.");
                System.out.println("Choose the next function: ");
                System.out.println("1) Display list employees");
                System.out.println("2) Add new employee");
                System.out.println("3) Edit employee");
                System.out.println("4) Back to menu");
                int choiceOne = Integer.parseInt(sc.nextLine());
                switch (choiceOne) {
                    case 1:
                        employeeService.displayList();
                        break;

                    case 2:
                        employeeService.addNew();
                        break;

                    case 3:
                        employeeService.editEmployee();
                        break;

                    case 4:
                        FuramaController.displayMainMenu();
                        break;

                    default:
                        System.err.println("False input. Please retry.");
                }
            } catch (Exception e) {
                System.err.println("Input number only. Retry.");
            }
        }
    }
