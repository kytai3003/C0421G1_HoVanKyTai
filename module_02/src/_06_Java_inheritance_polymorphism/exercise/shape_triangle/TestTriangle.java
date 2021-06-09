package _06_Java_inheritance_polymorphism.exercise.shape_triangle;

import java.util.Scanner;

public class TestTriangle {

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập màu sắc: ");
        String color = input.nextLine();
        System.out.println("Nhập độ dài cạnh 1: ");
        double side1 = input.nextDouble();
        System.out.println("Nhập độ dài cạnh 2: ");
        double side2 = input.nextDouble();
        System.out.println("Nhập độ dài cạnh 3: ");
        double side3 = input.nextDouble();

        Triangle triangle = new Triangle(color, true, side1, side2, side3);
        System.out.println(triangle);
        System.out.println("Perimeter: " + triangle.getPerimeter());
        System.out.println("Area: " + triangle.getArea());
    }
}
