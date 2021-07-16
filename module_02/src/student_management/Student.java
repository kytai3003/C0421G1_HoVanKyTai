package student_management;

public class Student extends Person {
    private String _class;

    public Student(int id, String name, int age, String address, String _class) {
        super(id, name, age, address);
        this._class = _class;
    }

    public Student() {
    }

    public String get_class() {
        return _class;
    }

    public void set_class(String _class) {
        this._class = _class;
    }

    public void move() {
        System.out.println("Đi bằng xe đạp");
    }

    public void study() {
        System.out.println("Học tiếng anh");
    }

    public void study(String subject){
        System.out.println("Học môn " + subject);
    }

    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                "_class='" + _class + '\'' +
                '}';
    }
}
