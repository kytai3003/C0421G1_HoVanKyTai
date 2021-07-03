package resort_management.library;

import resort_management.models.Booking;

import java.util.Comparator;

public class BookingComparator implements Comparator<Booking> {

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
}
