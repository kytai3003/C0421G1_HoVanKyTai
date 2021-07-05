package resort_management.controller;

import resort_management.services.FacilityServiceImpl;

import java.util.Scanner;

public class FacilityController {
    static FacilityServiceImpl facilityService = new FacilityServiceImpl();
    static Scanner sc =  new Scanner(System.in);
    public static void facilityFunction() {
        try {
            System.out.println("You chose Facility Management.");
            System.out.println("Choose the next function: ");
            System.out.println("1) Display list facilities");
            System.out.println("2) Add new facility");
            System.out.println("3) Display list facility maintenance");
            System.out.println("4) Return main menu");
            int choiceThree = Integer.parseInt(sc.nextLine());
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
