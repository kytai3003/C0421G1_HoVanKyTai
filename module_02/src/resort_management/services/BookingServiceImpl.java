package resort_management.services;

import resort_management.models.Booking;

import java.util.Scanner;
import java.util.TreeSet;

public class BookingServiceImpl implements BookingService {
    static Scanner sc = new Scanner(System.in);
    private static TreeSet<Booking> bookingList = new TreeSet<>();
    static {
        Booking booking1 = new Booking();
    }

    @Override
    public void displayListBooking() {

    }

    @Override
    public void addNewBooking() {

    }

    @Override
    public void creatNewContract() {

    }

    @Override
    public void displayListContract() {

    }

    @Override
    public void editContract() {

    }

}
