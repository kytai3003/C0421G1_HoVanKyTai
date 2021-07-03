package resort_management.models;

import java.util.Comparator;
import java.util.Objects;

public class Booking implements Comparator<Booking>, Comparable<Booking> {
    private String bookingCode;
    private String customerCode;
    private String nameService;
    private String typeService;
    private int dayStart, dayEnd;

    public Booking(String bookingCode, int dayStart, int dayEnd, String customerCode, String nameService, String typeService) {
        this.bookingCode = bookingCode;
        this.dayStart = dayStart;
        this.dayEnd = dayEnd;
        this.customerCode = customerCode;
        this.nameService = nameService;
        this.typeService = typeService;
    }

    public Booking() {
    }

    public String getBookingCode() {
        return bookingCode;
    }

    public void setBookingCode(String bookingCode) {
        this.bookingCode = bookingCode;
    }

    public int getDayStart() {
        return dayStart;
    }

    public void setDayStart(int dayStart) {
        this.dayStart = dayStart;
    }

    public int getDayEnd() {
        return dayEnd;
    }

    public void setDayEnd(int dayEnd) {
        this.dayEnd = dayEnd;
    }

    public String getCustomerCode() {
        return customerCode;
    }

    public void setCustomerCode(String customerCode) {
        this.customerCode = customerCode;
    }

    public String getNameService() {
        return nameService;
    }

    public void setNameService(String nameService) {
        this.nameService = nameService;
    }

    public String getTypeService() {
        return typeService;
    }

    public void setTypeService(String typeService) {
        this.typeService = typeService;
    }

    @Override
    public String toString() {
        return "Booking{" +
                "bookingCode='" + bookingCode + '\'' +
                ", dayStart='" + dayStart + '\'' +
                ", dayEnd='" + dayEnd + '\'' +
                ", customerCode='" + customerCode + '\'' +
                ", nameService='" + nameService + '\'' +
                ", typeService='" + typeService + '\'' +
                '}';
    }

    @Override
    public int compare(Booking o1, Booking o2) {
        if (o1.getDayStart() > o2.getDayStart()) {
            return 1;
        }
        else if (o1.getDayStart() < o2.getDayStart()) {
            return -1;
        }
        else {
            if (o1.getDayEnd() > o2.getDayEnd()) {
                return 1;
            } else if (o1.getDayEnd() < o2.getDayEnd()){
                return -1;
            } else {
                return 0;
            }
        }
    }

    @Override
    public int compareTo(Booking o) {
        if (getDayStart() > o.getDayStart()) {
            return 1;
        }
        else if (getDayStart() < o.getDayStart()) {
            return -1;
        }
        else {
            return 1;
        }
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Booking)) return false;
        Booking booking = (Booking) o;
        return dayStart == booking.dayStart &&
                dayEnd == booking.dayEnd &&
                Objects.equals(bookingCode, booking.bookingCode) &&
                Objects.equals(customerCode, booking.customerCode) &&
                Objects.equals(nameService, booking.nameService) &&
                Objects.equals(typeService, booking.typeService);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bookingCode, customerCode, nameService, typeService, dayStart, dayEnd);
    }
}
