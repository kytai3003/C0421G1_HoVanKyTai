package resort_management.controller;

import resort_management.services.FacilityServiceImpl;
import java.util.Scanner;

public class FacilityController {
    static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    static Scanner sc =  new Scanner(System.in);
    public static void facilityFunction() {
            System.out.println("You chose Facility Management.");
            System.out.println("Choose the next function: ");
            System.out.println("1) Display list facilities");
            System.out.println("2) Add new facility");
            System.out.println("3) Display list facility maintenance");
            System.out.println("4) Return main menu");
            int choiceThree = 0;
            try {
                choiceThree = Integer.parseInt(sc.nextLine());
            } catch (NumberFormatException e) {
                System.err.println("Input number only.");
            }
            switch (choiceThree) {
                case 1:
                    facilityService.displayList();
                    break;

                case 2:
                    System.out.println("You chose Add new facility. Choose the next function: ");
                    System.out.println("1) Add new villa");
                    System.out.println("2) Add new house");
                    System.out.println("3) Add new room");
                    System.out.println("4) Back to menu");
                    facilityService.addNew();
                    break;

                case 3:
                    facilityService.displayListMaintenance();
                    break;

                case 4:
                    FuramaController.displayMainMenu();
                    break;

                default:
                    System.err.println("False input. Please retry.");
            }
        }
    }

