package resort_management.models;

import java.io.Serializable;
import java.util.Objects;

public class House extends Facility implements Serializable {
    private String roomStandard;
    private String numberOfLevel;

    public House(String nameOfService, String usingArea, String price, String capacity, String typeOfHiring, String roomStandard, String numberOfLevel) {
        super(nameOfService, usingArea, price, capacity, typeOfHiring);
        this.roomStandard = roomStandard;
        this.numberOfLevel = numberOfLevel;
    }

    public House(String roomStandard, String numberOfLevel) {
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

    public String getNumberOfLevel() {
        return numberOfLevel;
    }

    public void setNumberOfLevel(String numberOfLevel) {
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
