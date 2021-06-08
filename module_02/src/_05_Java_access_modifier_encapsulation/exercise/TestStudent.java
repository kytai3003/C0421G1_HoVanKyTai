package _05_Java_access_modifier_encapsulation.exercise;

public class TestStudent {
    public static void main(String[] args) {
        Student student1 = new Student();
        student1.setName("Andy");
        student1.setClasses("C03");
        String result = student1.toString();
        System.out.println(result);
    }
}
