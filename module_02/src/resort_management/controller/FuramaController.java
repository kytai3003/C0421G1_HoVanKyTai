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
            System.out.println("4) Booking Management");
            System.out.println("5) Promotion Management");
            System.out.println("6) Exit");
            System.out.println("Choose the function: ");
            int choice = 0;
            try {
                choice = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Input number only.");
            }

            switch (choice) {
                case 1:
                    EmployeeController.employeeFunction();
                    break;

                case 2:
                    CustomerController.customerFunction();
                    break;

                case 3:
                    FacilityController.facilityFunction();
                    break;

                case 4:
                    BookingAndContractController.bookingFunction();
                    break;

                case 5:
                    PromotionController.promotionFunction();
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