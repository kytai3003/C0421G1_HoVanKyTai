package resort_management.services;

import resort_management.models.Booking;
import resort_management.models.Customer;
import resort_management.models.Facility;
import resort_management.services.interfaces.BookingService;

import java.util.*;

public class BookingServiceImpl implements BookingService {
    private static final Scanner sc = new Scanner(System.in);
    private static final TreeSet<Booking> bookingList = new TreeSet<>(); // Set để lưu trữ các booking được tạo mới
    private static final Queue<Booking> fromBookingToContract = new PriorityQueue<>(); // Queue trung gian lưu trữ các booking hợp lệ để làm hợp đồng (trừ Room)
    private static final CustomerServiceImpl customerServices = new CustomerServiceImpl();
    static {
        Booking bookingVilla1 = new Booking("V01", 20, 30, "B1", "Honeymoon", "Villa rent");
        Booking bookingRoom1 = new Booking("R01", 22, 23, "B2", "Special guest", "Room rent");
        bookingList.add(bookingRoom1);
        bookingList.add(bookingVilla1);
    }

    //Phương thức kiểm tra booking vừa được tạo mới có hợp lệ để làm hợp đồng hay không
    public void putIntoContractList(Booking booking) {
        // Mã booking đối với Room bắt đầu là R (không tạo contract), House bắt đầu là H, Villa bắt đầu là V
        String[] check = {"V", "H"};
        String[] code = booking.getBookingCode().split("");
        if (check[0].equals(code[0]) || check[1].equals(code[0])) {
            fromBookingToContract.offer(booking);
        }
    }

    @Override
    public void addNew() {
        Booking newBooking = new Booking();
        FacilityServiceImpl facilityService = new FacilityServiceImpl();
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

        String customerCode = "";
        if (customerServices.getList() == null) {
            System.out.println("No customer available. Input new code: "); // Danh sách null thì tạo mới
            newBooking.setCustomerCode(sc.nextLine());
        } else {
            boolean isAvailable = false;
            while (!isAvailable) {
                System.out.println("Customer code available. Choose one: "); //Danh sách code không null thì chứa vào arraylist để hiển thị
                ArrayList<String> availableCode = new ArrayList<>();
                for (Customer c : customerServices.getList()) {
                    availableCode.add(c.getCode());
                }
                System.out.println(availableCode);
                customerCode = sc.nextLine();
                for (Customer c : customerServices.getList()) {
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
        }
        System.out.println("Input name of service: ");
        newBooking.setNameService(sc.nextLine());
        System.out.println("Facilities available. Choose one type of service field by inputting facility name: "); // Hiển thị facility số lần sử dụng < 5
        for (Map.Entry<Facility, Integer> entry : facilityService.getList().entrySet()) {
            if (entry.getValue() < 5) {
                System.out.println(entry.getKey().getNameOfService() + ", used times: " + entry.getValue());
            }
        }
        String chooseFacility = "";
        boolean isLegal = false;
        while (!isLegal) {
            chooseFacility = sc.nextLine();
            for (Map.Entry<Facility, Integer> f : facilityService.getList().entrySet()) {
                if (chooseFacility.equals(f.getKey().getNameOfService())) {
                    isLegal = true;
                    f.setValue(f.getValue() + 1); // Thành công thì tăng số lần sử dụng lên 1
                    facilityService.getList().remove(f.getKey()); // Sau đó xóa facility vừa đặt ra khỏi danh sách (in use)
                    break;
                }
            }
            if (!isLegal) {
                System.err.println("False. Please input again.");
            } else {
                newBooking.setTypeService(chooseFacility);
                System.out.println("Success.");
            }
        }
        bookingList.add(newBooking);
        System.out.println("Successfully added.");
        // Kiểm tra booking...
        putIntoContractList(newBooking);
    }

    @Override
    public void displayList() {
        System.out.println("Available booking(s): ");
        for (Booking bk : bookingList) {
            System.out.println(bk);
        }
    }

    public Queue<Booking> getLegalBooking() {
        return fromBookingToContract;
    }

    public TreeSet<Booking> getBookingList() {
        return bookingList;
    }
}
