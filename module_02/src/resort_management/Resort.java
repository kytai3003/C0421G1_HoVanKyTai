package resort_management;

public class Resort {
    //Tất cả các dịch vụ này sẽ bao có các thông tin: Tên dịch vụ, Diện tích sử dụng,
    //Chi phí thuê, Số lượng người tối đa, Kiểu thuê
    // (bao gồm thuê theo năm, tháng, ngày, giờ).

    private String serviceName;
    private double usingArea;
    private double hireCharge;
    private double maxOfPeople;
    private String typeOfHiring;

    public Resort() {
    }

    public Resort(String serviceName, double usingArea, double hireCharge, double maxOfPeople, String typeOfHiring) {
        this.serviceName = serviceName;
        this.usingArea = usingArea;
        this.hireCharge = hireCharge;
        this.maxOfPeople = maxOfPeople;
        this.typeOfHiring = typeOfHiring;
    }

    public String getServiceName() {
        return serviceName;
    }

    public void setServiceName(String serviceName) {
        this.serviceName = serviceName;
    }

    public double getUsingArea() {
        return usingArea;
    }

    public void setUsingArea(double usingArea) {
        this.usingArea = usingArea;
    }

    public double getHireCharge() {
        return hireCharge;
    }

    public void setHireCharge(double hireCharge) {
        this.hireCharge = hireCharge;
    }

    public double getMaxOfPeople() {
        return maxOfPeople;
    }

    public void setMaxOfPeople(double maxOfPeople) {
        this.maxOfPeople = maxOfPeople;
    }

    public String getTypeOfHiring() {
        return typeOfHiring;
    }

    public void setTypeOfHiring(String typeOfHiring) {
        this.typeOfHiring = typeOfHiring;
    }

    @Override
    public String toString() {
        return "Resort{" +
                "serviceName='" + serviceName + '\'' +
                ", usingArea=" + usingArea +
                ", hireCharge=" + hireCharge +
                ", maxOfPeople=" + maxOfPeople +
                ", typeOfHiring='" + typeOfHiring + '\'' +
                '}';
    }
}
