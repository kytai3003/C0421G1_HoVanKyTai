package resort_management.controller;

import resort_management.services.BookingServiceImpl;
import java.util.Scanner;

public class BookingController {
    static BookingServiceImpl bookingService = new BookingServiceImpl();
    static Scanner sc = new Scanner(System.in);
    public static void bookingFunction() {
        try {
            System.out.println("You chose Booking Management.");
            System.out.println("Choose the next function: ");
            System.out.println("1) Add new booking");
            System.out.println("2) Display list booking");
            System.out.println("3) Create new constracts");
            System.out.println("4) Display list contracts");
            System.out.println("5) Edit contracts");
            System.out.println("6) Return main menu");
            int choiceFour = Integer.parseInt(sc.nextLine());
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
