package _03_Java_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CrossLineSum {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Tạo ma trận
        System.out.println("Nhập số dòng: ");
        int rows = scanner.nextInt();
        System.out.println("Nhập số cột: ");
        int cols = scanner.nextInt();
        int[][] matrix;
        matrix =  new int[rows][cols];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                System.out.println("Nhập phần tử vào ma trận: ");
                matrix[i][j] = scanner.nextInt();
            }
        }
        // Hiển thị ma trận
        for (int[] x: matrix) {
            System.out.println(Arrays.toString(x));
        }

        // Hiển thị kết quả
        System.out.println("Tổng của đường chéo chính trong ma trận là " + totalThecross(matrix));
    }

    private static int totalThecross(int[][] arr) {
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum += arr[i][i];
        }
        return sum;
    }
}
