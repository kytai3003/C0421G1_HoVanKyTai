package resort_management;

public class Villa extends Resort{
    //Riêng Villa sẽ có thêm thông tin: Tiêu chuẩn phòng, Mô tả tiện nghi khác,
    // Diện tích hồ bơi, Số tầng.

    private String standardOfRoom;
    private double poolArea;
    private int numberOfLevel;
    private String otherConvenience;

    public Villa() {
    }

    public Villa(String serviceName, double usingArea, double hireCharge, double maxOfPeople, String typeOfHiring, String standardOfRoom, double poolArea, int numberOfLevel, String otherConvenience) {
        super(serviceName, usingArea, hireCharge, maxOfPeople, typeOfHiring);
        this.standardOfRoom = standardOfRoom;
        this.poolArea = poolArea;
        this.numberOfLevel = numberOfLevel;
        this.otherConvenience = otherConvenience;
    }

    public Villa(String standardOfRoom, double poolArea, int numberOfLevel, String otherConvenience) {
        this.standardOfRoom = standardOfRoom;
        this.poolArea = poolArea;
        this.numberOfLevel = numberOfLevel;
        this.otherConvenience = otherConvenience;
    }

    public String getStandardOfRoom() {
        return standardOfRoom;
    }

    public void setStandardOfRoom(String standardOfRoom) {
        this.standardOfRoom = standardOfRoom;
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

    public String getOtherConvenience() {
        return otherConvenience;
    }

    public void setOtherConvenience(String otherConvenience) {
        this.otherConvenience = otherConvenience;
    }

    @Override
    public String toString() {
        return "Villa{" +
                "standardOfRoom='" + standardOfRoom + '\'' +
                ", poolArea=" + poolArea +
                ", numberOfLevel=" + numberOfLevel +
                ", otherConvenience='" + otherConvenience + '\'' +
                '}';
    }
}
