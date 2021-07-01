package resort_management.models;

import java.util.Objects;

public class Room extends Facility{
    private String freeServices;

    public Room(String nameOfService, String usingArea, String price, int capacity, String typeOfHiring, String freeServices) {
        super(nameOfService, usingArea, price, capacity, typeOfHiring);
        this.freeServices = freeServices;
    }

    public Room(String freeServices) {
        this.freeServices = freeServices;
    }

    public Room() {
    }

    public String getFreeServices() {
        return freeServices;
    }

    public void setFreeServices(String freeServices) {
        this.freeServices = freeServices;
    }

    @Override
    public String toString() {
        return "Room{" +
                "nameOfService='" + nameOfService + '\'' +
                ", usingArea=" + usingArea +
                ", price=" + price +
                ", capacity=" + capacity +
                ", typeOfHiring='" + typeOfHiring + '\'' +
                ", freeServices='" + freeServices + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Room)) return false;
        if (!super.equals(o)) return false;
        Room room = (Room) o;
        return freeServices.equals(room.freeServices);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), freeServices);
    }
}
