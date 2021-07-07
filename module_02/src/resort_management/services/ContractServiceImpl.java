package resort_management.services;

import resort_management.common.ContractReadAndWriteFile;
import resort_management.common.LegalBookingRAW;
import resort_management.models.Booking;
import resort_management.models.Contract;
import resort_management.models.Customer;
import resort_management.services.interfaces.ContractService;
import java.util.LinkedList;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Scanner;

public class ContractServiceImpl implements ContractService<Contract> {
    private final static Scanner sc = new Scanner(System.in);
    private final static String FILE_PATH_CONTRACT = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\resort_management\\data\\contract.csv";
    private final static String FILE_PATH_LEGALBOOKING = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\resort_management\\data\\legalBooking.csv";
    private final static CustomerServiceImpl customerService = new CustomerServiceImpl();
    private final static ContractReadAndWriteFile contractReadAndWrite = new ContractReadAndWriteFile();
    private static LinkedList<Contract> contracts = new LinkedList<>(); // List lưu trữ các hợp đồng
    private static Queue<Booking> fromBookingToContract = new PriorityQueue<>(); // Queue trung gian lưu trữ các booking hợp lệ để làm hợp đồng (trừ Room)

    @Override
    public void addNew() { // Lấy các booking từ Queue fromBookingToContract ra để làm hợp đồng
        fromBookingToContract = (Queue<Booking>) new LegalBookingRAW().readFile(FILE_PATH_LEGALBOOKING);
        contracts = (LinkedList<Contract>) contractReadAndWrite.readFile(FILE_PATH_CONTRACT);
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
        if (fromBookingToContract.peek() != null) {
            newContract.setBookingCode(fromBookingToContract.peek().getBookingCode());
            newContract.setCustomerCode(fromBookingToContract.peek().getCustomerCode());
            fromBookingToContract.poll();
        } else {
            System.out.println("No booking available. System out.");
            return;
        }
        System.out.println("Input deposit amount: ");
        double deposit = inputAmount();
        newContract.setDeposit(deposit);
        System.out.println("Input total pay amount: ");
        double totalPay = inputAmount();
        newContract.setTotalPay(totalPay);
        System.out.println("New contract created:" + newContract.toString());
        contracts.offer(newContract);
        contractReadAndWrite.writeFile(FILE_PATH_CONTRACT, contracts);
        fromBookingToContract = (Queue<Booking>) new LegalBookingRAW().readFile(FILE_PATH_LEGALBOOKING); // Sau khi đã làm hợp đồng xong thì remove khỏi hàng đợi làm contract
        fromBookingToContract.remove();
        new LegalBookingRAW().writeFile(FILE_PATH_LEGALBOOKING, fromBookingToContract);
    }

    @Override
    public void displayList() {
        contracts = (LinkedList<Contract>) new ContractReadAndWriteFile().readFile(FILE_PATH_CONTRACT);
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
        contracts = (LinkedList<Contract>) new ContractReadAndWriteFile().readFile(FILE_PATH_CONTRACT);
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
        contractReadAndWrite.writeFile(FILE_PATH_CONTRACT, contracts);
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
                        String bookingCode = inputBookingCode();
                        contracts.get(index).setBookingCode(bookingCode);
                        break;

                    case 2:
                        String customerCode = inputCode();
                        contracts.get(index).setCustomerCode(customerCode);
                        break;

                    case 3:
                        System.out.println("Input new deposit amount: ");
                        double deposit = inputAmount();
                        contracts.get(index).setDeposit(deposit);
                        break;

                    case 4:
                        System.out.println("Input new total amount: ");
                        double totalPay = inputAmount();
                        contracts.get(index).setTotalPay(totalPay);
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

    public int inputAmount() {
        boolean isLegalTotal = false;
        int amount = 0;
        while (!isLegalTotal) {
            try {
                amount = Integer.parseInt(sc.nextLine());
                System.out.println("Success.");
                isLegalTotal = true;
            } catch (NumberFormatException e) {
                System.err.println("Input number only. Retry: ");
            }
        }
        return amount;
    }

    public String inputCode() {
        System.out.println("Customer code available. Choose one: ");
        String code = "";
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
                System.out.println("Success.");
            } else {
                System.err.println("Input false. Please retry. ");
            }
        }
        return code;
    }

    public String inputBookingCode() {
        System.out.println("Input new booking code: ");
        boolean isLegalCode = false;
        String code = "";
        while (!isLegalCode) {
            try {
                code = sc.nextLine();
                System.out.println("Success.");
                isLegalCode = true;
            } catch (NumberFormatException e) {
                System.err.println("Input number only. Retry: ");
            }
        }
        return code;
    }
}
