package resort_management.services;

import resort_management.models.Booking;
import resort_management.models.Contract;
import resort_management.models.Customer;
import resort_management.models.Facility;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    static Scanner sc = new Scanner(System.in);
    static TreeSet<Booking> bookingList = new TreeSet<>();
    static PriorityQueue<Booking> fromBookingToContract = new PriorityQueue<>();
    static LinkedList<Contract> contracts = new LinkedList<>();

    static {
        Booking bookingVilla1 = new Booking("V01", 20, 30, "B1", "Honeymoon", "Villa rent");
        Booking bookingRoom1 = new Booking("R01", 22, 23, "B2", "Special guest", "Room rent");
        bookingList.add(bookingRoom1);
        bookingList.add(bookingVilla1);
        fromBookingToContract.offer(bookingVilla1);
    }

    static CustomerServiceImpl cs = new CustomerServiceImpl();

    public void putIntoContractList(Booking booking) {
        // Mã booking đối với Room bắt đầu là R (không tạo contract), House bắt đầu là H, Villa bắt đầu là V
        String[] check = {"V", "H"};
        String[] code = booking.getBookingCode().split("");
        if (check[0].equals(code[0]) || check[1].equals(code[0])) {
            fromBookingToContract.offer(booking);
        }
    }

    @Override
    public void creatNewContract() {
        Contract newContract = new Contract();
        System.out.println("You chose Creat new contract.");
        System.out.println("Input contract number: ");
        boolean isLegalNumbContract = false;
        while (!isLegalNumbContract) {
            try {
                newContract.setContractNumb(Integer.parseInt(sc.nextLine()));
                System.out.println("Success.");
                isLegalNumbContract = true;
            } catch (Exception e) {
                System.err.println("Input number only. Retry.");
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
        boolean isLegalDeposit = false;
        while (!isLegalDeposit) {
            try {
                newContract.setDeposit(Integer.parseInt(sc.nextLine()));
                System.out.println("Success.");
                isLegalDeposit = true;
            } catch (Exception e) {
                System.err.println("Input number only. Retry.");
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
                System.err.println("Input number only. Retry.");
            }
        }
        System.out.println("New contract created:" + newContract.toString());
        contracts.offer(newContract);
    }

    @Override
    public void displayListContract() {
        System.out.println("Available contract: ");
        for (Contract c : contracts) {
            System.out.println(c.toString());
        }
    }

    @Override
    public void editContract() {
        if (contracts.isEmpty()) {
            System.err.println("No contract available.");
        } else {
            displayListContract();
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
                } catch (Exception e) {
                    System.err.println("Input number only. Retry. ");
                }
                if (!isLegal) {
                    System.err.println("Wrong code. Please retry. ");
                } else {
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
                                        } catch (Exception e) {
                                            System.err.println("Input number only. Retry: ");
                                        }
                                    }
                                    break;

                                case 2:
                                    System.out.println("Customer code available. Choose one: ");
                                    for (Customer c : cs.getList()) {
                                        System.out.println(c.getCode());
                                    }
                                    boolean isAvailable = false;
                                    while (!isAvailable) {
                                        String newCustomerCode = sc.nextLine();
                                        for (Customer c : cs.getList()) {
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
                                        } catch (Exception e) {
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
                                        } catch (Exception e) {
                                            System.err.println("Input number only. Retry: ");
                                        }
                                    }
                                    break;

                                default:
                                    return;
                            }
                            isLegalEdit = true;
                        } catch (Exception e) {
                            System.err.println("Input number only. Retry: ");
                        }
                    }
                }
            }
        }
    }

    @Override
    public void addNew() {
        Booking newBooking = new Booking();
        FacilityServiceImpl fs = new FacilityServiceImpl();
        System.out.println("You chose Add new booking");
        boolean isExist = false;
        System.out.println("Input booking code: " + "\n" + "(Starting with 'V' for villa booking, 'H' for house booking and 'R' for room booking)");
        String booking = "";
        while (!isExist) {
            booking = sc.nextLine();
            for (Booking bk : bookingList) {
                if (booking.equals(bk.getBookingCode())) {
                    isExist = false;
                    break;
                } else {
                    isExist = true;
                }
            }
            if (!isExist) {
                System.err.println("Duplicate code. Please retry. ");
            } else {
                newBooking.setBookingCode(booking);
                System.out.println("Success.");
            }
        }
        System.out.println("Input starting day: ");
        boolean isLegalStartDay = false;
        int startDay = 1;
        while (!isLegalStartDay) {
            try {
                startDay = Integer.parseInt(sc.nextLine());
                if (startDay > 0 && startDay < 31) {
                    newBooking.setDayStart(startDay);
                    System.out.println("Success.");
                    isLegalStartDay = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Input day between 1 and 31. Retry: ");
            }
        }
        System.out.println("Input ending day: ");
        boolean isLegalEndDay = false;
        while (!isLegalEndDay) {
            try {
                int endDay = Integer.parseInt(sc.nextLine());
                if (endDay > 0 && endDay < 31 && endDay > startDay) {
                    newBooking.setDayEnd(endDay);
                    System.out.println("Success.");
                    isLegalEndDay = true;
                } else {
                    throw new Exception();
                }
            } catch (Exception e) {
                System.err.println("Input day between 1 and 31 and after the start day. Retry: ");
            }
        }
        boolean isAvailable = false;
        while (!isAvailable) {
            System.out.println("Customer code available. Choose one: ");
            ArrayList<String> availableCode = new ArrayList<>();
            for (Customer c : cs.getList()) {
                availableCode.add(c.getCode());
            }
            System.out.println(availableCode);
            String customerCode = sc.nextLine();
            for (Customer c : cs.getList()) {
                if (customerCode.equals(c.getCode())) {
                    isAvailable = true;
                    break;
                }
            }
            if (isAvailable) {
                newBooking.setCustomerCode(customerCode);
                System.out.println("Success.");
            } else {
                System.err.println("Input false. Please retry. ");
            }
        }
        System.out.println("Input name of service: ");
        newBooking.setNameService(sc.nextLine());
        System.out.println("Facilities available. Choose one type of service field by inputting facility name: ");
        for (Map.Entry<Facility, Integer> entry : fs.getList().entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey().getNameOfService() + ", used times: " + entry.getValue());
            }
        }
        String choose = "";
        boolean isLegal = false;
        while (!isLegal) {
            choose = sc.nextLine();
            for (Map.Entry<Facility, Integer> f : fs.getList().entrySet()) {
                if (choose.equals(f.getKey().getNameOfService())) {
                    isLegal = true;
                    f.setValue(f.getValue() + 1);
                    fs.getList().remove(f.getKey());
                    break;
                }
            }
            if (!isLegal) {
                System.err.println("False. Please input again.");
            } else {
                newBooking.setTypeService(choose);
                System.out.println("Success.");
            }
        }
        bookingList.add(newBooking);
        System.out.println("Successfully added.");
        putIntoContractList(newBooking);
    }

    @Override
    public void displayList() {
        System.out.println("Available booking(s): ");
        for (Booking bk : bookingList) {
            System.out.println(bk);
        }
    }

    public TreeSet<Booking> getBookingList() {
        return bookingList;
    }
}
