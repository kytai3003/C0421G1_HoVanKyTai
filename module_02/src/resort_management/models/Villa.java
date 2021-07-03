package resort_management.models;

import java.util.Objects;

public class Villa extends Facility{
    private String roomStandard;
    private String poolArea;
    private int numberOfLevel;

    public Villa() {
    }

    public Villa(String nameOfService, String usingArea, String price, int capacity, String typeOfHiring, String roomStandard, String poolArea, int numberOfLevel) {
        super(nameOfService, usingArea, price, capacity, typeOfHiring);
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfLevel = numberOfLevel;
    }

    public Villa(String roomStandard, String poolArea, int numberOfLevel) {
        this.roomStandard = roomStandard;
        this.poolArea = poolArea;
        this.numberOfLevel = numberOfLevel;
    }

    public String getRoomStandard() {
        return roomStandard;
    }

    public void setRoomStandard(String roomStandard) {
        this.roomStandard = roomStandard;
    }

    public String getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(String poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfLevel() {
        return numberOfLevel;
    }

    public void setNumberOfLevel(int numberOfLevel) {
        this.numberOfLevel = numberOfLevel;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "nameOfService='" + nameOfService + '\'' +
                ", usingArea=" + usingArea +
                ", price=" + price +
                ", capacity=" + capacity +
                ", typeOfHiring='" + typeOfHiring + '\'' +
                ", roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfLevel=" + numberOfLevel +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Villa)) return false;
        if (!super.equals(o)) return false;
        Villa villa = (Villa) o;
        return numberOfLevel == villa.numberOfLevel &&
                roomStandard.equals(villa.roomStandard) &&
                poolArea.equals(villa.poolArea);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), roomStandard, poolArea, numberOfLevel);
    }
}
