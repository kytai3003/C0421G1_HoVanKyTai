package student_management;

public class Teacher extends Person {
    private String level;

    public Teacher() {
    }

    public Teacher(int id, String name, int age, String address, String level) {
        super(id, name, age, address);
        this.level = level;
    }

    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public void move() {
        System.out.println("Đi bằng xe ô tô");
    }

    @Override
    public String toString() {
        return "Teacher{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", address='" + address + '\'' +
                "level='" + level + '\'' +
                '}';
    }
}
