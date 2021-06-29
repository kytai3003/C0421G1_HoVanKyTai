package resort_management.models;

public class Villa extends Facility{
    private String roomStandard;
    private double poolArea;
    private int numberOfLevel;

    public Villa() {
    }

    public Villa(String roomStandard, double poolArea, int numberOfLevel) {
        super();
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

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
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
                "roomStandard='" + roomStandard + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfLevel=" + numberOfLevel +
                ", nameOfService='" + nameOfService + '\'' +
                ", usingArea=" + usingArea +
                ", price=" + price +
                ", capacity=" + capacity +
                ", typeOfHiring='" + typeOfHiring + '\'' +
                '}';
    }

}
