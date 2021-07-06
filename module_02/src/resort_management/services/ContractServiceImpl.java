package resort_management.services;

import resort_management.models.Contract;
import resort_management.models.Customer;
import resort_management.services.interfaces.ContractService;

import java.util.LinkedList;
import java.util.Scanner;

public class ContractServiceImpl implements ContractService<Contract> {
    private final static Scanner sc = new Scanner(System.in);
    private final static LinkedList<Contract> contracts = new LinkedList<>(); // List lưu trữ các hợp đồng
    private final static BookingServiceImpl bookingService = new BookingServiceImpl();
    private final static CustomerServiceImpl customerService = new CustomerServiceImpl();

    @Override
    public void addNew() { // Lấy các booking từ fromBookingToContract ra để làm hợp đồng
        Contract newContract = new Contract();
        System.out.println("You chose Creat new contract.");
        System.out.println("Input contract number: ");
        boolean isLegalNumbContract = false;
        while (!isLegalNumbContract) {
            try {
                newContract.setContractNumb(Integer.parseInt(sc.nextLine()));
                System.out.println("Success.");
                isLegalNumbContract = true;
            } catch (NumberFormatException e) {
                System.err.println("Input false, number only. Retry.");
            }
        }
        if (bookingService.getLegalBooking().peek() != null) {
            newContract.setBookingCode(bookingService.getLegalBooking().peek().getBookingCode());
            newContract.setCustomerCode(bookingService.getLegalBooking().peek().getCustomerCode());
            bookingService.getLegalBooking().poll();
        } else {
            System.out.println("No booking available. System out.");
            return;
        }
        System.out.println("Input deposit amount: ");
        boolean isLegalDeposit = false;
        while (!isLegalDeposit) {
            try {
                newContract.setDeposit(Integer.parseInt(sc.nextLine()));
                System.out.println("Success.");
                isLegalDeposit = true;
            } catch (Exception e) {
                System.err.println("Input false, number only. Retry.");
            }
        }
        System.out.println("Input total pay amount: ");
        boolean isLegalTotal = false;
        while (!isLegalTotal) {
            try {
                newContract.setTotalPay(Integer.parseInt(sc.nextLine()));
                System.out.println("Success.");
                isLegalTotal = true;
            } catch (Exception e) {
                System.err.println("Input false, number only. Retry.");
            }
        }
        System.out.println("New contract created:" + newContract.toString());
        contracts.offer(newContract);
    }

    @Override
    public void displayList() {
        if (contracts.isEmpty()) {
            System.err.println("No contract available.");
        } else {
            for (Contract c : contracts) {
                System.out.println(c.toString());
            }
        }
    }

    @Override
    public void editContract() {
        if (contracts.isEmpty()) {
            System.err.println("No contract available.");
        } else {
            displayList();
            System.out.println("Input contract number to edit: ");
            boolean isLegal = false;
            int numberContract;
            int index = 0;
            while (!isLegal) {
                try {
                    numberContract = Integer.parseInt(sc.nextLine());
                    for (int i = 0; i < contracts.size(); i++) {
                        if (numberContract == contracts.get(i).getContractNumb()) {
                            isLegal = true;
                            index = i;
                            break;
                        }
                    }
                } catch (NumberFormatException e) {
                    System.err.println("Input number only. Retry. ");
                }
                if (!isLegal) {
                    System.err.println("Wrong code. Please retry. ");
                } else {
                    editContractIfTrue(index);
                }
            }
        }
    }

    public void editContractIfTrue(int index) {
        System.out.println("Choose property to edit: ");
        System.out.println("1) Booking code");
        System.out.println("2) Customer code");
        System.out.println("3) Deposit amount");
        System.out.println("4) Total amount");
        System.out.println("5) Exit");
        boolean isLegalEdit = false;
        while (!isLegalEdit) {
            try {
                int choice = Integer.parseInt(sc.nextLine());
                switch (choice) {
                    case 1:
                        System.out.println("Input new booking code: ");
                        boolean isLegalCode = false;
                        while (!isLegalCode) {
                            try {
                                contracts.get(index).setContractNumb(Integer.parseInt(sc.nextLine()));
                                System.out.println("Success.");
                                isLegalCode = true;
                            } catch (NumberFormatException e) {
                                System.err.println("Input number only. Retry: ");
                            }
                        }
                        break;

                    case 2:
                        System.out.println("Customer code available. Choose one: ");
                        for (Customer c : customerService.getList()) {
                            System.out.println(c.getCode());
                        }
                        boolean isAvailable = false;
                        while (!isAvailable) {
                            String newCustomerCode = sc.nextLine();
                            for (Customer c : customerService.getList()) {
                                if (newCustomerCode.equals(c.getCode())) {
                                    isAvailable = true;
                                    break;
                                }
                            }
                            if (isAvailable) {
                                contracts.get(index).setCustomerCode(newCustomerCode);
                                System.out.println("Success.");
                            } else {
                                System.err.println("Input false. Please retry. ");
                            }
                        }
                        break;

                    case 3:
                        System.out.println("Input new deposit amount: ");
                        boolean isLegalDeposit = false;
                        while (!isLegalDeposit) {
                            try {
                                contracts.get(index).setDeposit(Integer.parseInt(sc.nextLine()));
                                System.out.println("Success.");
                                isLegalDeposit = true;
                            } catch (NumberFormatException e) {
                                System.err.println("Input number only. Retry: ");
                            }
                        }
                        break;

                    case 4:
                        System.out.println("Input new total amount: ");
                        boolean isLegalTotal = false;
                        while (!isLegalTotal) {
                            try {
                                contracts.get(index).setTotalPay(Integer.parseInt(sc.nextLine()));
                                System.out.println("Success.");
                                isLegalTotal = true;
                            } catch (NumberFormatException e) {
                                System.err.println("Input number only. Retry: ");
                            }
                        }
                        break;

                    case 5:
                        return;

                    default:
                        System.out.println("Input false. Try again");
                }
                isLegalEdit = true;
            } catch (Exception e) {
                System.err.println("Input number only. Retry: ");
            }
        }
    }
}
