package resort_management;

public class House extends Villa{

    //Riêng House sẽ có thêm thông tin: Tiêu chuẩn phòng, Mô tả tiện nghi khác, Số tầng.

    public House() {
    }

    public House(String serviceName, double usingArea, double hireCharge, double maxOfPeople, String typeOfHiring, String standardOfRoom, double poolArea, int numberOfLevel, String otherConvenience) {
        super(serviceName, usingArea, hireCharge, maxOfPeople, typeOfHiring, standardOfRoom, poolArea, numberOfLevel, otherConvenience);
    }

    public House(String standardOfRoom, double poolArea, int numberOfLevel, String otherConvenience) {
        super(standardOfRoom, poolArea, numberOfLevel, otherConvenience);
    }

    public String toString() {
        return "House{" +
                "standardOfRoom='" + super.getStandardOfRoom() + '\'' +
                ", numberOfLevel=" + super.getNumberOfLevel() +
                ", otherConvenience='" + super.getOtherConvenience() + '\'' +
                '}';
    }
}
