package resort_management.services;

import resort_management.common.BookingReadAndWriteFile;
import resort_management.common.CustomerReadAndWriteFile;
import resort_management.common.FacilityReadAndWriteFile;
import resort_management.common.LegalBookingRAW;
import resort_management.models.Booking;
import resort_management.models.Customer;
import resort_management.models.Facility;
import resort_management.services.interfaces.BookingService;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static Scanner sc = new Scanner(System.in);
    private static TreeSet<Booking> bookingList = new TreeSet<>(); // Set để lưu trữ các booking được tạo mới
    private static Queue<Booking> fromBookingToContract = new PriorityQueue<>(); // Queue trung gian lưu trữ các booking hợp lệ để làm hợp đồng (trừ Room)
    private static Map<Facility, Integer> villaMap = new LinkedHashMap<>();
    private static Map<Facility, Integer> houseMap = new LinkedHashMap<>();
    private static Map<Facility, Integer> roomMap = new LinkedHashMap<>();
    private static Map<Facility, Integer> facilityMap = new LinkedHashMap<>();
    private static List<Customer> customers = new LinkedList<>();
    private static final String FILE_PATH_BOOKING = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\resort_management\\data\\booking.csv";
    private static final String FILE_PATH_CUSTOMER = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\resort_management\\data\\customer.csv";
    private static final String FILE_PATH_LEGALBOOKING = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\resort_management\\data\\legalBooking.csv";
    private static final String FILE_PATH_VILLA = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\resort_management\\data\\villa.csv";
    private static final String FILE_PATH_HOUSE = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\resort_management\\data\\house.csv";
    private static final String FILE_PATH_ROOM = "D:\\C2401G1_HoVanKyTai\\module_02\\src\\resort_management\\data\\room.csv";



    //Phương thức kiểm tra booking vừa được tạo mới có hợp lệ để làm hợp đồng hay không
    public void putIntoContractList(Booking booking) {
        // Mã booking đối với Room bắt đầu là R (không tạo contract), House bắt đầu là H, Villa bắt đầu là V
        fromBookingToContract = (Queue<Booking>) new LegalBookingRAW().readFile(FILE_PATH_LEGALBOOKING);
        String[] check = {"V", "H"};
        String[] code = booking.getBookingCode().split("");
        if (check[0].equals(code[0]) || check[1].equals(code[0])) {
            fromBookingToContract.offer(booking);
        }
        new LegalBookingRAW().writeFile(FILE_PATH_LEGALBOOKING, fromBookingToContract);
    }

    @Override
    public void addNew() {
        bookingList = (TreeSet<Booking>) new BookingReadAndWriteFile().readFile(FILE_PATH_BOOKING);
        Booking newBooking = new Booking();
        System.out.println("You chose Add new booking");
        if (bookingList.isEmpty()) {
            System.out.println("Input booking code: " + "\n" + "(Starting with 'V' for villa booking, 'H' for house booking and 'R' for room booking)");
            newBooking.setBookingCode(sc.nextLine());
        } else {
            boolean isExist = true;
            System.out.println("Input booking code: " + "\n" + "(Starting with 'V' for villa booking, 'H' for house booking and 'R' for room booking)");
            String booking = "";
            while (isExist) {
                booking = sc.nextLine();
                for (Booking bk : bookingList) {
                    if (booking.equals(bk.getBookingCode())) {
                        isExist = true;
                        break;
                    } else {
                        isExist = false;
                    }
                }
                if (isExist) {
                    System.err.println("Duplicate code. Please retry. ");
                } else {
                    newBooking.setBookingCode(booking);
                    System.out.println("Success.");
                }
            }
        }
            int startDay = inputDayStart();
            newBooking.setDayStart(startDay);
            int endDay = inputDayEnd(startDay);
            newBooking.setDayEnd(endDay);
            String customerCode = inputCustomerCode();
            newBooking.setCustomerCode(customerCode);
            System.out.println("Input name of service: ");
            newBooking.setNameService(sc.nextLine());
            String chooseFacility = inputFacility();
            newBooking.setTypeService(chooseFacility);
            bookingList.add(newBooking);
            System.out.println("Successfully added.");
            new BookingReadAndWriteFile().writeFile(FILE_PATH_BOOKING, bookingList);
            // Kiểm tra booking...
            putIntoContractList(newBooking);
        }

    @Override
    public void displayList() {
        bookingList = (TreeSet<Booking>) new BookingReadAndWriteFile().readFile(FILE_PATH_BOOKING);
        if (bookingList.isEmpty()) {
            System.err.println("Booking list is empty.");
        } else {
            for (Booking b: bookingList) {
                System.out.println(b.toString());
            }
        }
    }

    public int inputDayStart() {
        System.out.println("Input starting day: ");
        boolean isLegalStartDay = false;
        int startDay = 1;
        while (!isLegalStartDay) {
            try {
                startDay = Integer.parseInt(sc.nextLine());
                if (startDay > 0 && startDay < 31) {
                    System.out.println("Success.");
                    isLegalStartDay = true;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Input day between 1 and 31. Retry: ");
            }
        }
        return startDay;
    }

    public int inputDayEnd(int startDay) {
        System.out.println("Input ending day: ");
        boolean isLegalEndDay = false;
        int endDay = 0;
        while (!isLegalEndDay) {
            try {
                endDay = Integer.parseInt(sc.nextLine());
                if (endDay > 0 && endDay < 31 && endDay > startDay) {
                    System.out.println("Success.");
                    isLegalEndDay = true;
                } else {
                    throw new NumberFormatException();
                }
            } catch (NumberFormatException e) {
                System.err.println("Input day between 1 and 31 and after the start day. Retry: ");
            }
        }
        return endDay;
    }

    public String inputCustomerCode() {
        CustomerReadAndWriteFile customerReadAndWriteFile = new CustomerReadAndWriteFile();
        customers = customerReadAndWriteFile.readFile(FILE_PATH_CUSTOMER);
        String customerCode = "";
        if (customers.isEmpty()) {
            System.out.println("No customer available. Input new code: "); // Danh sách null thì tạo mới
            customerCode = sc.nextLine();
        } else {
            boolean isAvailable = false;
            while (!isAvailable) {
                System.out.println("Customer code available. Choose one: "); //Danh sách code không null thì chứa vào arraylist để hiển thị
                ArrayList<String> availableCode = new ArrayList<>();
                for (Customer c : customers) {
                    availableCode.add(c.getCode());
                }
                System.out.println(availableCode);
                customerCode = sc.nextLine();
                for (Customer c : customers) {
                    if (customerCode.equals(c.getCode())) {
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
        }
        return customerCode;
    }

    public String inputFacility() {
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
        FacilityReadAndWriteFile facilityReadAndWriteFile = new FacilityReadAndWriteFile();
        villaMap = facilityReadAndWriteFile.readFile(FILE_PATH_VILLA);
        houseMap = facilityReadAndWriteFile.readFile(FILE_PATH_HOUSE);
        roomMap = facilityReadAndWriteFile.readFile(FILE_PATH_ROOM);
        facilityMap = facilityService.getList();
        facilityMap.putAll(villaMap);
        facilityMap.putAll(houseMap);
        facilityMap.putAll(roomMap);
        System.out.println("Facilities available. Choose one type of service field by inputting facility name: "); // Hiển thị facility số lần sử dụng < 5
        for (Map.Entry<Facility, Integer> entry : facilityMap.entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey().getNameOfService() + ", used times: " + entry.getValue());
            }
        }
        String chooseFacility = "";
        boolean isLegal = false;
        while (!isLegal) {
            chooseFacility = sc.nextLine();
            for (Map.Entry<Facility, Integer> f : facilityMap.entrySet()) {
                if (chooseFacility.equals(f.getKey().getNameOfService())) {
                    isLegal = true;
                    f.setValue(f.getValue() + 1); // Thành công thì tăng số lần sử dụng lên 1
                    facilityMap.remove(f.getKey()); // Sau đó xóa facility vừa đặt ra khỏi danh sách (in use)
                    break;
                }
            }
            if (!isLegal) {
                System.err.println("False. Please input again.");
            } else {
                System.out.println("Success.");
            }
        }
        return chooseFacility;
    }

    public Queue<Booking> getLegalBooking() {
        return fromBookingToContract;
    }

    public TreeSet<Booking> getBookingList() {
        return bookingList;
    }

}
