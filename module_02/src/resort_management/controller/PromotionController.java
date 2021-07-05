package resort_management.controller;

import resort_management.services.PromotionServiceImpl;

import java.util.Scanner;

public class PromotionController {
    static PromotionServiceImpl promotionService = new PromotionServiceImpl();
    static Scanner sc = new Scanner(System.in);
    public static void promotionFunction() {
        try {
            System.out.println("You chose Promotion Management.");
            System.out.println("Choose the next function: ");
            System.out.println("1) Display list customers use service");
            System.out.println("2) Display list customers get voucher");
            System.out.println("3) Return main menu");
            int choiceFive = Integer.parseInt(sc.nextLine());
            switch (choiceFive) {

                case 1:
                    promotionService.displayServiceList();
                    break;

                case 2:
                    promotionService.displayVoucherList();
                    break;

                case 3:
                    FuramaController.displayMainMenu();

                default:
                    System.err.println("False input. Please retry.");
            }
        } catch (Exception e) {
            System.err.println("Input number only. Retry.");
        }
    }
}
