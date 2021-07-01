package resort_management.models;

import java.util.Objects;

public class House extends Facility{
    private String roomStandard;
    private int numberOfLevel;

    public House(String nameOfService, String usingArea, String price, int capacity, String typeOfHiring, String roomStandard, int numberOfLevel) {
        super(nameOfService, usingArea, price, capacity, typeOfHiring);
        this.roomStandard = roomStandard;
        this.numberOfLevel = numberOfLevel;
    }

    public House(String roomStandard, int numberOfLevel) {
        this.roomStandard = roomStandard;
        this.numberOfLevel = numberOfLevel;
    }

    public House() {
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public int getNumberOfLevel() {
        return numberOfLevel;
    }

    public void setNumberOfLevel(int numberOfLevel) {
        this.numberOfLevel = numberOfLevel;
    }

    @Override
    public String toString() {
        return "House{" +
                "nameOfService='" + nameOfService + '\'' +
                ", usingArea=" + usingArea +
                ", price=" + price +
                ", capacity=" + capacity +
                ", typeOfHiring='" + typeOfHiring + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", numberOfLevel=" + numberOfLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof House)) return false;
        if (!super.equals(o)) return false;
        House house = (House) o;
        return numberOfLevel == house.numberOfLevel &&
                roomStandard.equals(house.roomStandard);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomStandard, numberOfLevel);
    }
}
