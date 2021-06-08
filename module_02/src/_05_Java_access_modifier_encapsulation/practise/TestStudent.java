package _05_Java_access_modifier_encapsulation.practise;

public class TestStudent {
    public static void main(String[] args) {
        Student.change();

        Student student1 = new Student(111, "Linh");
        Student student2 = new Student(222, "Hoang");
        Student student3 = new Student(333, "Anh");

        student1.display();
        student2.display();
        student3.display();
    }
}
