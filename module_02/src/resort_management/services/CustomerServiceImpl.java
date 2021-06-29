package resort_management.services;

import resort_management.models.Customer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{
    static Scanner sc = new Scanner(System.in);
    public static List<Customer> customers = new LinkedList<>();

    static {
        Customer customer1 = new Customer(11, "Khach hang A", "11/12/1999", "Male",
                "khachhangA@gmail.com", 200123123, "1234567890", "Diamond", "Da Nang");
        Customer customer2 = new Customer(12, "Khach hang B", "20/06/1995", "Female",
                "khachhangB@gmail.com", 200123456, "1234567891", "Gold", "Ha Noi");
        Customer customer3 = new Customer(13, "Khach hang C", "18/12/1988", "Female",
                "khachhangC@gmail.com", 200123789, "1234567892", "Platinum", "TP. HCM");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }

    @Override
    public void displayList() {
        for (Customer c: customers) {
            System.out.println(c);
        }
    }


    @Override
    public void addNew() {
        System.out.println("Input code: ");
        int code = Integer.parseInt(sc.nextLine());
        System.out.println("Input name: ");
        String name = sc.nextLine();
        System.out.println("Input day of birth: ");
        String dayOfBirth = sc.nextLine();
        System.out.println("Input sex: ");
        String sex = sc.nextLine();
        System.out.println("Input email: ");
        String email = sc.nextLine();
        System.out.println("Input ID number: ");
        int idNumber = Integer.parseInt(sc.nextLine());
        System.out.println("Input phone number: ");
        String phone = sc.nextLine();
        System.out.println("Input type. Choose one: ");
        String[] typeCustomer = {"Diamond", "Platinium", "Gold", "Silver", "Member"};
        String type = sc.nextLine();
        boolean isExist = false;
        for (int i = 0; i< typeCustomer.length; i++) {
            if (type.equals(typeCustomer[i])) {
                isExist = true;
                break;
            }
        }
        if (isExist) {
            System.out.println("Input address: ");
            String address = sc.nextLine();
            System.out.println("Successful!");
            Customer newCustomer = new Customer(code, name, dayOfBirth, sex, email, idNumber, phone, type, address);
            customers.add(newCustomer);
        } else {
            System.err.println("Input type false. Please retry.");
        }
    }

    @Override
    public void editCustomer() {

    }
}
