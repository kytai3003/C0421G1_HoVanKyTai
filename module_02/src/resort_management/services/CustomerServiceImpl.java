package resort_management.services;

import resort_management.models.Customer;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService{
    static Scanner sc = new Scanner(System.in);
    public static List<Customer> customers = new LinkedList<>();

    static {
        Customer customer1 = new Customer("B1", "Khach hang A", "11/12/1999", "Male",
                "khachhangA@gmail.com", 200123123, "1234567890", "Diamond", "Da Nang");
        Customer customer2 = new Customer("B2", "Khach hang B", "20/06/1995", "Female",
                "khachhangB@gmail.com", 200123456, "1234567891", "Gold", "Ha Noi");
        Customer customer3 = new Customer("B3", "Khach hang C", "18/12/1988", "Female",
                "khachhangC@gmail.com", 200123789, "1234567892", "Platinum", "TP. HCM");
        customers.add(customer1);
        customers.add(customer2);
        customers.add(customer3);
    }
    String[] typeCustomer = {"Diamond", "Platinium", "Gold", "Silver", "Member"};

    @Override
    public void displayList() {
        for (Customer c: customers) {
            System.out.println(c);
        }
    }

    public List<Customer> getList() {
        return customers;
    }


    @Override
    public void addNew() {
        System.out.println("Input code: ");
        String code = sc.nextLine();
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
        System.out.println("Input address: ");
        String address = sc.nextLine();
        System.out.println("Input type. Choose one: ");
        for (int i = 0; i < typeCustomer.length; i++) {
            System.out.println(i + ") " + typeCustomer[i]);
        }
        String type = "";
        boolean isTrueType = false;
        while (!isTrueType) {
            int choiceType = Integer.parseInt(sc.nextLine());
            switch (choiceType) {
                case 0:
                    isTrueType = true;
                    type = typeCustomer[0];
                    break;
                case 1:
                    isTrueType = true;
                    type = typeCustomer[1];
                    break;
                case 2:
                    isTrueType = true;
                    type = typeCustomer[2];
                    break;
                case 3:
                    isTrueType = true;
                    type = typeCustomer[3];
                    break;
                default:
                    System.err.println("Input qualification false. Please retry.");
            }
        }
        Customer newCustomer = new Customer(code, name, dayOfBirth, sex, email, idNumber, phone, type, address);
        customers.add(newCustomer);
        System.out.println("Successful!");
    }

    @Override
    public void editCustomer() {
        System.out.println("You chose Customer Editing.");
        boolean isTrueCode = false;
        while (!isTrueCode) {
            System.out.println("Input customer code: ");
            String input = sc.nextLine();
            boolean isExist = false;
            int index = 0;
            for (int i = 0; i < customers.size(); i++) {
                if (customers.get(i).getCode().equals(input)) {
                    isExist = true;
                    index = i;
                    break;
                }
            }
            if (!isExist) {
                System.err.println("Code not found!");
            } else {
                isTrueCode = true;
                System.out.println(customers.get(index).toString());
                System.out.println("Choose the property: ");
                System.out.println("1) Edit name");
                System.out.println("2) Edit day of birth");
                System.out.println("3) Edit sex");
                System.out.println("4) Edit email");
                System.out.println("5) Edit ID number");
                System.out.println("6) Edit phone");
                System.out.println("7) Edit type");
                System.out.println("8) Edit address");
                System.out.println("9) Back.");
                int customerChoice = Integer.parseInt(sc.nextLine());
                switch (customerChoice) {
                    case 1:
                        System.out.println("Input new name: ");
                        String newName = sc.nextLine();
                        customers.get(index).setName(newName);
                        break;

                    case 2:
                        System.out.println("Input new day of birth: ");
                        String newDob = sc.nextLine();
                        customers.get(index).setDayOfBirth(newDob);
                        break;

                    case 3:
                        System.out.println("Input new sex: ");
                        String newSex = sc.nextLine();
                        customers.get(index).setSex(newSex);
                        break;

                    case 4:
                        System.out.println("Input new email: ");
                        String newEmail = sc.nextLine();
                        customers.get(index).setEmail(newEmail);
                        break;

                    case 5:
                        System.out.println("Input new ID number: ");
                        int newIdNumb = Integer.parseInt(sc.nextLine());
                        customers.get(index).setIdNumber(newIdNumb);
                        break;

                    case 6:
                        System.out.println("Input phone number: ");
                        String newPhone = sc.nextLine();
                        customers.get(index).setPhoneNumber(newPhone);
                        break;

                    case 7:
                        System.out.println("Choose one type: ");
                        for (int i = 0; i < typeCustomer.length; i++) {
                            System.out.println(i + ") " + typeCustomer[i]);
                        }
                        String newType = "";
                        boolean isTrue = false;
                        while (!isTrue) {
                            int choiceType = Integer.parseInt(sc.nextLine());
                            switch (choiceType) {
                                case 0:
                                    isTrue = true;
                                    newType = typeCustomer[0];
                                    break;
                                case 1:
                                    isTrue = true;
                                    newType = typeCustomer[1];
                                    break;
                                case 2:
                                    isTrue = true;
                                    newType = typeCustomer[2];
                                    break;
                                case 3:
                                    isTrue = true;
                                    newType = typeCustomer[3];
                                    break;
                                case 4:
                                    isTrue = true;
                                    newType = typeCustomer[4];
                                    break;
                                default:
                                    System.err.println("Input qualification false. Please retry.");
                            }
                        }
                        customers.get(index).setType(newType);
                        break;

                    case 8:
                        System.out.println("Input new address: ");
                        String newAddress = sc.nextLine();
                        customers.get(index).setAddress(newAddress);
                        break;

                    case 9:
                        return;

                    default:
                        System.err.println("False input. Please retry.");
                }
            }
        }
    }
}
