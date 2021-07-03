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
        String check = "R";
        String[] code = booking.getBookingCode().split("");
        boolean isLegal = check.equals(code[0]);
        if (!isLegal) {
            fromBookingToContract.offer(booking);
        }
    }

    @Override
    public void creatNewContract() {
        Contract newContract = new Contract();
        System.out.println("You chose Creat new contract.");
        System.out.println("Input contract number: ");
        newContract.setContractNumb(sc.nextInt());
        if (fromBookingToContract.peek() != null) {
            newContract.setBookingCode(fromBookingToContract.peek().getBookingCode());
            newContract.setCustomerCode(fromBookingToContract.peek().getCustomerCode());
            fromBookingToContract.poll();
        } else {
            System.out.println("No booking available. System out.");
            return;
        }
        System.out.println("Input deposit amount: ");
        newContract.setDeposit(sc.nextInt());
        System.out.println("Input total pay amount: ");
        newContract.setTotalPay(sc.nextInt());
        System.out.println("New contract created:" + newContract.toString());
        contracts.offer(newContract);
    }

    @Override
    public void displayListContract() {
        System.out.println("Available contract: ");
        for (Contract c: contracts) {
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
                numberContract = sc.nextInt();
                for (int i = 0; i < contracts.size(); i++) {
                    if (numberContract == contracts.get(i).getContractNumb()) {
                        isLegal = true;
                        index = i;
                        break;
                    }
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
                    int choice = sc.nextInt();
                    switch (choice) {
                        case 1:
                            System.out.println("Input new booking code: ");
                            contracts.get(index).setContractNumb(sc.nextInt());
                            System.out.println("Success.");
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
                            contracts.get(index).setDeposit(sc.nextInt());
                            System.out.println("Success.");
                            break;

                        case 4:
                            System.out.println("Input new total amount: ");
                            contracts.get(index).setTotalPay(sc.nextInt());
                            System.out.println("Success.");
                            break;

                        default:
                            return;
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
        newBooking.setDayStart(Integer.parseInt(sc.nextLine()));
        System.out.println("Input ending day: ");
        newBooking.setDayEnd(Integer.parseInt(sc.nextLine()));
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
        System.out.println("Facilities available. Input name: ");
        fs.displayList();
        String choose = "";
        boolean isLegal = false;
        while (!isLegal) {
            choose = sc.nextLine();
            for (Map.Entry<Facility, Integer> f: fs.getList().entrySet()) {
                if (choose.equals(f.getKey().getNameOfService())) {
                    isLegal = true;
                    f.setValue(f.getValue() + 1);
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
        for (Booking bk: bookingList) {
            System.out.println(bk);
        }
    }
}
