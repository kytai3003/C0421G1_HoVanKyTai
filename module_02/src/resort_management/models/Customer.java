package resort_management.models;

public class Customer extends Person implements Comparable<Customer> {
    private String type;
    private String address;

    public Customer(String code, String name, String dayOfBirth, String sex, String email, int idNumber, String phoneNumber, String type, String address) {
        super(code, name, dayOfBirth, sex, email, idNumber, phoneNumber);
        this.type = type;
        this.address = address;
    }

    public Customer(String type, String address) {
        this.type = type;
        this.address = address;
    }

    public Customer() {
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "Customer{" +
                "type='" + type + '\'' +
                ", address='" + address + '\'' +
                ", code=" + code +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", idNumber=" + idNumber +
                ", phoneNumber=" + phoneNumber +
                '}';
    }

    @Override
    public int compareTo(Customer o) {
        if (getIdNumber() > o.getIdNumber()) {
            return 1;
        }
        else if (getIdNumber() < o.getIdNumber()) {
            return -1;
        }
        else {
            return 0;
        }
    }
}
