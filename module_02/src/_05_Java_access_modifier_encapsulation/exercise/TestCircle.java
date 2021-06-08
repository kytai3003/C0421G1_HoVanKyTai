package _05_Java_access_modifier_encapsulation.exercise;

public class TestCircle {
    public static void main(String[] args) {
        Circle circle = new Circle(5);
        System.out.println(circle.getArea());
        System.out.println(circle.getRadius());
    }
}
