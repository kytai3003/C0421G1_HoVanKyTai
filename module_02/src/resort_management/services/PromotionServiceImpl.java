package resort_management.services;

import resort_management.models.Booking;
import resort_management.models.Customer;
import resort_management.services.interfaces.PromotionService;

import java.util.Scanner;
import java.util.Stack;
import java.util.TreeSet;

public class PromotionServiceImpl implements PromotionService {
    private static final Scanner sc = new Scanner(System.in);
    private static final TreeSet<Customer> customerUseService = new TreeSet<>(); // Set lưu danh sách khách nhận vé số vietlot
    private static final CustomerServiceImpl customerService = new CustomerServiceImpl();
    private static final BookingServiceImpl bookingService = new BookingServiceImpl();
    private static final Stack<String> vouchers = new Stack<>(); // Kho stack lưu vé số vietlot

    @Override
    public void displayServiceList() {
        addToServiceList();
        if (customerUseService.isEmpty()) {
            System.err.println("Patrons list is empty.");
        } else {
            System.out.println("Patrons list: ");
            for (Customer c : customerUseService) {
                System.out.println(c.toString());
            }
        }
    }

    // Phương thức đưa khách hàng vào danh sách nhận vé số
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
                System.out.println(vouchers.pop()); // Nhận xong vé nào thì xóa vé đó
            }
            customerUseService.clear(); // Nhận xong xóa khỏi danh sách
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
