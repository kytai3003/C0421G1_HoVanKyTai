package _05_Java_access_modifier_encapsulation.exercise;

public class Student {
    private String name = "John";
    private String classes = "C02";

    public Student(String name, String classes) {
        this.name = name;
        this.classes = classes;
    }

    public Student() {
    }

    protected void setName(String name) {
        this.name = name;
    }

    protected void setClasses(String classes) {
        this.classes = classes;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", classes='" + classes + '\'' +
                '}';
    }
}
