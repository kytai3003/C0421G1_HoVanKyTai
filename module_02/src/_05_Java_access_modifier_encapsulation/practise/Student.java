package _05_Java_access_modifier_encapsulation.practise;

public class Student {
    private int rollno;
    private String name;
    private static String college = "ABCD";

    public Student(int rollno, String name) {
        this.rollno = rollno;
        this.name = name;
    }

    public Student() {
    }

    static void change() {
        college = "CODEGYM";
    }

    void display() {
        System.out.println(this.rollno + " " + name + " " + college);
    }
}
