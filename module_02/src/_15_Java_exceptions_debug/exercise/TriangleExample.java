package _15_Java_exceptions_debug.exercise;

import java.util.Scanner;

public class TriangleExample {
    static Scanner sc = new Scanner(System.in);
    public static void main(String[] args){
        testLegal();
    }

    private static void testLegal(){
        boolean isLegal = false;
        while (!isLegal) {
            try {
                System.out.println("Nhập cạnh 1: ");
                double sideA = sc.nextDouble();
                System.out.println("Nhập cạnh 2: ");
                double sideB = sc.nextDouble();
                System.out.println("Nhập cạnh 3: ");
                double sideC = sc.nextDouble();
                // Kiểm tra số âm
                if (sideA < 0 || sideB < 0 || sideC < 0) {
                    throw new IllegalTriangleException("Không được nhập số âm. Mời nhập lại");
                    // Kiểm tra tính chất 3 cạnh của tam giác
                } else if (sideA + sideB <= sideC || sideA + sideC <= sideB || sideB + sideC <= sideA) {
                    throw new IllegalTriangleException("Tổng 2 cạnh phải lớn hơn cạnh còn lại. Mời nhập lại.");
                } else {
                    isLegal = true;
                    System.out.println("Tam giác hợp lệ.");
                }
            } catch (IllegalTriangleException ex) {
                System.err.println("Sinh ngoại lệ: " + ex.getMessage());
            }
        }
    }
}