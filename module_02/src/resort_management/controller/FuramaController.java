package resort_management.controller;

import resort_management.services.BookingServiceImpl;
import resort_management.services.CustomerServiceImpl;
import resort_management.services.EmployeeServiceImpl;
import resort_management.services.FacilityServiceImpl;

import java.util.Scanner;

public class FuramaController {
    public static Scanner sc = new Scanner(System.in);
    public static void displayMainMenu() {
        do {
            System.out.println("--------------Welcome to management system---------------");
            System.out.println("1) Employee Management");
            System.out.println("2) Customer Management");
            System.out.println("3) Facility Management");
            System.out.println("4) Booking Management");
            System.out.println("5) Promotion Management");
            System.out.println("6) Exit");
            System.out.println("Choose the function: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    EmployeeServiceImpl employeeService = new EmployeeServiceImpl();
                    System.out.println("You chose Employee Management.");
                    System.out.println("Choose the next function: ");
                    System.out.println("1) Display list employees");
                    System.out.println("2) Add new employee");
                    System.out.println("3) Edit employee");
                    System.out.println("4) Back to menu");
                    int choiceOne = sc.nextInt();
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
                            displayMainMenu();
                            break;

                        default:
                            System.err.println("False input. Please retry.");
                    }
                    break;

                case 2:
                    CustomerServiceImpl customerService = new CustomerServiceImpl();
                    System.out.println("You chose Customer Management.");
                    System.out.println("Choose the next function: ");
                    System.out.println("1) Display list customers");
                    System.out.println("2) Add new customer");
                    System.out.println("3) Edit customer");
                    System.out.println("4) Back to menu");
                    int choiceTwo = sc.nextInt();
                    switch (choiceTwo) {
                        case 1:
                            customerService.displayList();
                            break;

                        case 2:
                            customerService.addNew();
                            break;

                        case 3:
                            customerService.editCustomer();
                            break;

                        case 4:
                            displayMainMenu();
                            break;

                        default:
                            System.err.println("False input. Please retry.");
                    }
                    break;

                case 3:
                    FacilityServiceImpl facilityService = new FacilityServiceImpl();
                    System.out.println("You chose Facility Management.");
                    System.out.println("Choose the next function: ");
                    System.out.println("1) Display list facilities");
                    System.out.println("2) Add new facility");
                    System.out.println("3) Display list facility maintenance");
                    System.out.println("4) Return main menu");
                    int choiceThree = sc.nextInt();
                    switch (choiceThree) {
                        case 1:
                            facilityService.displayList();
                            break;

                        case 2:
                            facilityService.addNew();
                            break;

                        case 3:
                            facilityService.displayListMaintenance();
                            break;

                        case 4:
                            displayMainMenu();
                            break;

                        default:
                            System.err.println("False input. Please retry.");
                    }
                    break;

                case 4:
                    BookingServiceImpl bookingService = new BookingServiceImpl();
                    System.out.println("You chose Booking Management.");
                    System.out.println("Choose the next function: ");
                    System.out.println("1) Add new booking");
                    System.out.println("2) Display list booking");
                    System.out.println("3) Create new constracts");
                    System.out.println("4) Display list contracts");
                    System.out.println("5) Edit contracts");
                    System.out.println("6) Return main menu");
                    int choiceFour = sc.nextInt();
                    switch (choiceFour) {
                        case 1:
                            bookingService.addNew();
                            break;

                        case 2:
                            bookingService.displayList();
                            break;

                        case 3:
                            bookingService.creatNewContract();
                            break;

                        case 4:
                            bookingService.displayListContract();
                            break;

                        case 5:
                            bookingService.editContract();
                            break;

                        case 6:
                            displayMainMenu();
                            break;

                        default:
                            System.err.println("False input. Please retry.");
                    }
                    break;

                case 5:
                    System.out.println("You chose Promotion Management.");
                    System.out.println("Choose the next function: ");
                    System.out.println("1) Display list customers use service");
                    System.out.println("2) Display list customers get voucher");
                    System.out.println("3) Return main menu");
                    int choiceFive = sc.nextInt();
                    break;

                case 6:
                    System.exit(1);
                    break;

                default:
                    System.err.println("Your input is false. Please rechoose.");
            }
        } while (true);
    }
}
