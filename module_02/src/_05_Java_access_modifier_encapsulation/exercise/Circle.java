package _05_Java_access_modifier_encapsulation.exercise;

public class Circle {
    private double radius = 1.0;
    private String color = "red";

    public Circle(double radius) {
        this.radius = radius;
    }

    public Circle() {
    }

    public double getRadius() {
        return this.radius;
    }

    public double getArea() {
        return Math.pow(this.radius, 2) * Math.PI;
    }

}
