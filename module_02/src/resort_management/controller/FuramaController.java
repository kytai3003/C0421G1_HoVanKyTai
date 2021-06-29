package resort_management.controller;

import java.util.Scanner;

public class FuramaController {
    public static Scanner sc = new Scanner(System.in);
    public static void displayMainMenu() {
        do {
            System.out.println("--------------Welcome to management system---------------");
            System.out.println("1) Employee Management");
            System.out.println("2) Customer Management");
            System.out.println("3) Facility Management");
            System.out.println("4) Booking Managerment");
            System.out.println("5) Promotion Management");
            System.out.println("6) Exit");
            System.out.println("Choose the function: ");
            int choice = sc.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("You chose Employee Management.");
                    System.out.println("Choose the next function: ");
                    System.out.println("1) Display list employees");
                    System.out.println("2) Add new employee");
                    System.out.println("3) Edit employee");
                    System.out.println("4) Return main menu");
                    int choiceOne = sc.nextInt();
                    break;

                case 2:
                    System.out.println("You chose Customer Management.");
                    System.out.println("Choose the next function: ");
                    System.out.println("1) Display list customers");
                    System.out.println("2) Add new customer");
                    System.out.println("3) Edit customer");
                    System.out.println("4) Return main menu");
                    int choiceTwo = sc.nextInt();
                    break;

                case 3:
                    System.out.println("You chose Facility Management.");
                    System.out.println("Choose the next function: ");
                    System.out.println("1) Display list facilities");
                    System.out.println("2) Add new facility");
                    System.out.println("3) Edit facility maintenance");
                    System.out.println("4) Return main menu");
                    int choiceThree = sc.nextInt();
                    break;

                case 4:
                    System.out.println("You chose Booking Managerment.");
                    System.out.println("Choose the next function: ");
                    System.out.println("1) Add new booking");
                    System.out.println("2) Display list booking");
                    System.out.println("3) Create new constracts");
                    System.out.println("4) Display list contracts");
                    System.out.println("5) Edit contracts");
                    System.out.println("6) Return main menu");
                    int choiceFour = sc.nextInt();
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
                    System.out.println("Your input is false. Please rechoose.");
            }
        } while (true);
    }

    public static void main(String[] args) {
        displayMainMenu();
    }
}
