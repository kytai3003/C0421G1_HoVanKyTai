package resort_management.services;

import resort_management.models.Booking;
import resort_management.models.Customer;

import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class PromotionServiceImpl implements PromotionService {
    static Scanner sc = new Scanner(System.in);
    static TreeSet<Customer> customerUseService = new TreeSet<>();
    static CustomerServiceImpl customerService = new CustomerServiceImpl();
    static BookingServiceImpl bookingService = new BookingServiceImpl();
    static Stack<String> vouchers = new Stack<>();

    @Override
    public void displayServiceList() {
        addToServiceList();
        if (!bookingService.getBookingList().isEmpty()) {
            System.out.println("Patrons list: ");
            for (Customer c : customerUseService) {
                System.out.println(c.toString());
            }
        } else {
            System.out.println("Patrons list is empty.");
        }
    }

    public void addToServiceList() {
        for (Booking b : bookingService.getBookingList()) {
            for (Customer c : customerService.getList()) {
                if (b.getCustomerCode().equals(c.getCode())) {
                    customerUseService.add(c);
                }
            }
        }
    }

    @Override
    public void displayVoucherList() {
        insertVoucher();
        if (vouchers.size() > customerUseService.size()) {
            for (Booking b : bookingService.getBookingList()) {
                System.out.print("Customer code : " + b.getCustomerCode() + " receives ");
                System.out.println(vouchers.pop());
            }
            customerUseService.clear();
        } else if (customerUseService.size() == 0){
            System.out.println("Patrons list is empty.");
        } else {
            System.err.println("Voucher is not enough. Please insert more. ");
        }
    }

    public void insertVoucher() {
        boolean isLegal = false;
        int voucher50 = 0;
        int voucher20 = 0;
        int voucher10 = 0;
        while (!isLegal) {
            boolean isLegal50 = false;
            System.out.println("Input amount of 50% voucher: ");
            while (!isLegal50) {
                try {
                    voucher50 = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < voucher50; i++) {
                        vouchers.push("50% voucher");
                    }
                    isLegal50 = true;
                } catch (Exception ex) {
                    System.err.println("Input number only. Retry.");
                }
            }
            boolean isLegal20 = false;
            System.out.println("Input amount of 20% voucher: ");
            while (!isLegal20) {
                try {
                    voucher20 = Integer.parseInt(sc.nextLine());
                    for (int j = 0; j < voucher20; j++) {
                        vouchers.push("20% voucher");
                    }
                    isLegal20 = true;
                } catch (Exception ex) {
                    System.err.println("Input number only. Retry.");
                }
            }
            boolean isLegal10 = false;
            System.out.println("Input amount of 10% voucher: ");
            while (!isLegal10) {
                try {
                    voucher10 = Integer.parseInt(sc.nextLine());
                    for (int k = 0; k < voucher10; k++) {
                        vouchers.push("10% voucher");
                    }
                    isLegal10 = true;
                    isLegal = true;
                    System.out.println("Available vouchers are: " + "\n" + "10% - " + voucher10 + "\n" + "20% - " + voucher20 + "\n" + "50% - " + voucher50);
                } catch (Exception ex) {
                    System.err.println("Input number only. Retry.");
                }
            }
        }
    }
}
