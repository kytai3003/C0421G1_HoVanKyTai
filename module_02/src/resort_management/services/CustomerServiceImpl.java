package resort_management.services;

import resort_management.common.CustomerReadAndWriteFile;
import resort_management.models.Customer;
import resort_management.services.interfaces.CustomerService;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class CustomerServiceImpl implements CustomerService {
    static Scanner sc = new Scanner(System.in);
    public static List<Customer> customers = new LinkedList<>();
    private static final String FILE_PATH = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\resort_management\\data\\customer.csv";
    String[] typeCustomer = {"Diamond", "Platinium", "Gold", "Silver", "Member"};

    @Override
    public void displayList() {
        for (Customer e: new CustomerReadAndWriteFile().readFile(FILE_PATH)) {
            System.out.println(e.toString());
        }
    }

    public List<Customer> getList() {
        return customers;
    }

    @Override
    public void addNew() {
        customers = new CustomerReadAndWriteFile().readFile(FILE_PATH);
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
        boolean isLegalNumber = false;
        int idNumber = 0;
        while (!isLegalNumber){
            try {
                idNumber = Integer.parseInt(sc.nextLine());
                isLegalNumber = true;
                System.out.println("Success");
            } catch (Exception e) {
                System.err.println("Input number only. Retry:");
            }
        }
        System.out.println("Input phone number: ");
        String phone = sc.nextLine();
        System.out.println("Input address: ");
        String address = sc.nextLine();
        String type = inputType();
        Customer newCustomer = new Customer(code, name, dayOfBirth, sex, email, idNumber, phone, type, address);
        customers.add(newCustomer);
        System.out.println("Successful!");
        new CustomerReadAndWriteFile().writeFile(FILE_PATH,customers);
    }

    @Override
    public void editCustomer() {
        customers = new CustomerReadAndWriteFile().readFile(FILE_PATH);
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
                boolean isLegalEdit = false;
                System.out.println("Result: " + "\n" + customers.get(index).toString());
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
                while (!isLegalEdit) {
                    try {
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
                                boolean isLegalID = false;
                                while (!isLegalID) {
                                    try {
                                        int newIdNumb = Integer.parseInt(sc.nextLine());
                                        customers.get(index).setIdNumber(newIdNumb);
                                        System.out.println("Success");
                                        isLegalID = true;
                                    } catch (Exception e) {
                                        System.err.println("Input number only. Retry:");
                                    }
                                }
                                break;

                            case 6:
                                System.out.println("Input phone number: ");
                                String newPhone = sc.nextLine();
                                customers.get(index).setPhoneNumber(newPhone);
                                break;

                            case 7:
                                String newType = inputType();
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
                        isLegalEdit = true;
                    } catch (Exception e) {
                        System.err.println("Input number only. Retry: ");
                    }
                }
            }
        }
        new CustomerReadAndWriteFile().writeFile(FILE_PATH, customers);
    }

    public String inputType() {
        System.out.println("Input type. Choose one: ");
        for (int i = 0; i < typeCustomer.length; i++) {
            System.out.println(i + ") " + typeCustomer[i]);
        }
        String type = "";
        boolean isTrueType = false;
        while (!isTrueType) {
            try {
                int choiceType = Integer.parseInt(sc.nextLine());
                switch (choiceType) {
                    case 0:
                        type = typeCustomer[0];
                        break;
                    case 1:
                        type = typeCustomer[1];
                        break;
                    case 2:
                        type = typeCustomer[2];
                        break;
                    case 3:
                        type = typeCustomer[3];
                        break;
                    case 4:
                        type = typeCustomer[4];
                        break;
                    default:
                        System.err.println("Input type false. Please retry.");
                }
                isTrueType = true;
            } catch (NumberFormatException e) {
                System.err.println(e.getMessage());
            }
        }
        return type;
    }
}
