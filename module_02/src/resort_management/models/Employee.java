package resort_management.models;

public class Employee extends Person{
    private String position;
    private double salary;
    private String qualification;

    public Employee(String code, String name, String dayOfBirth, String sex, String email, int idNumber,
                    String phoneNumber, String position, double salary, String qualification) {
        super(code, name, dayOfBirth, sex, email, idNumber, phoneNumber);
        this.position = position;
        this.salary = salary;
        this.qualification = qualification;
    }

    public Employee(String position, double salary, String qualification) {
        this.position = position;
        this.salary = salary;
        this.qualification = qualification;
    }

    public Employee() {
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public String getQualification() {
        return qualification;
    }

    public void setQualification(String qualification) {
        this.qualification = qualification;
    }

    @Override
    public String toString() {
        return "Employee{" +
                "code=" + code +
                ", name='" + name + '\'' +
                ", dayOfBirth='" + dayOfBirth + '\'' +
                ", sex='" + sex + '\'' +
                ", email='" + email + '\'' +
                ", idNumber=" + idNumber +
                ", phoneNumber=" + phoneNumber +
                ", position='" + position + '\'' +
                ", salary=" + salary +
                ", qualification='" + qualification + '\'' +
                '}';
    }
}
