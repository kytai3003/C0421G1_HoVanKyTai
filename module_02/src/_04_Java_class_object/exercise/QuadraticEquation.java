package _04_Java_class_object.exercise;

import java.util.Scanner;

public class QuadraticEquation {
    private double a, b, c;

    public QuadraticEquation() {
    }

    public QuadraticEquation(double a, double b, double c) {
        this.a = a;
        this.b = b;
        this.c = c;
    }

    public double getA() {
        return this.a;
    }

    public double getB() {
        return this.b;
    }

    public double getC() {
        return this.c;
    }

    public double getDiscriminant() {
        return (this.b*this.b - this.c * this.a * 4);
    }

    public void getRoot1() {
        double root1;
        if (getDiscriminant() < 0) {
            System.out.println("The equation has no roots");
        } else if (getDiscriminant() == 0) {
            root1 = -this.b / (this.a * 2);
            System.out.println("Root1 is: " + root1);
        } else {
            root1 = (-this.b + Math.pow(getDiscriminant(), 0.5)) / 2*this.a;
            System.out.println("Root1 is: " + root1);
        }
    }

    public void getRoot2() {
        double root2;
        if (getDiscriminant() < 0) {
            System.out.println("The equation has no roots");
        } else if (getDiscriminant() == 0) {
            root2 = -this.b / (this.a * 2);
            System.out.println("Root2 is: " + root2);
        } else {
            root2 = (-this.b - Math.pow(getDiscriminant(), 0.5)) / 2*this.a;
            System.out.println("Root2 is: " + root2);
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Input a: ");
        double a = scanner.nextDouble();
        System.out.println("Input b: ");
        double b = scanner.nextDouble();
        System.out.println("Input c: ");
        double c = scanner.nextDouble();
        QuadraticEquation equation = new QuadraticEquation(a, b, c);

        System.out.println("Discriminant is: " + equation.getDiscriminant());
        equation.getDiscriminant();
        equation.getRoot1();
        equation.getRoot2();
    }
}
