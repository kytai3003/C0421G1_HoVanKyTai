package _15_Java_exceptions_debug.exercise;

import java.util.Scanner;

public class TriangleExample {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Nhập cạnh 1: ");
        double sideA = sc.nextDouble();
        System.out.println("Nhập cạnh 2: ");
        double sideB = sc.nextDouble();
        System.out.println("Nhập cạnh 3: ");
        double sideC = sc.nextDouble();
        try {
            testLegal(sideA, sideB, sideC);
        } catch (IllegalTriangleException2 ex) {
            System.err.println("Sinh ngoại lệ: " + ex.getMessage());
        } catch (IllegalTriangleException ex) {
            System.err.println("Sinh ngoại lệ: " + ex.getMessage());
        } catch (Exception e) {
            System.err.println(e.getMessage());
        }
    }

    private static void testLegal(double x, double y, double z) throws IllegalTriangleException, IllegalTriangleException2 {
        if (x < 0 || y < 0 || z < 0) {
            throw new IllegalTriangleException("Không được nhập số âm");
        } else if (x + y <= z || x + z <= y || y + z <= x){
            throw new IllegalTriangleException2("Tổng 2 cạnh phải > cạnh còn lại.");
        } else {
            System.out.println("Tam giác hợp lệ.");
        }
    }
}