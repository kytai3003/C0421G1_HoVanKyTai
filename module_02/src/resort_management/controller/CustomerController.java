package resort_management.controller;

import resort_management.services.CustomerServiceImpl;

import java.util.Scanner;

public class CustomerController {
    static CustomerServiceImpl customerService = new CustomerServiceImpl();
    static Scanner sc = new Scanner(System.in);
    public static void customerFunction() {
            System.out.println("You chose Customer Management.");
            System.out.println("Choose the next function: ");
            System.out.println("1) Display list customers");
            System.out.println("2) Add new customer");
            System.out.println("3) Edit customer");
            System.out.println("4) Back to menu");
            int choiceTwo = 0;
            try {
                choiceTwo = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Input number only.");
            }
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
                    FuramaController.displayMainMenu();
                    break;

                default:
                    System.err.println("False input. Please retry.");
            }
        }
    }
