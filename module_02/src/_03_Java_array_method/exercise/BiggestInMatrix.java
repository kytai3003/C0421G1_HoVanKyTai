package _03_Java_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class BiggestInMatrix {
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

        // Tìm GTLN
        System.out.println("Giá trị lớn nhất trong ma trận là: " + findBiggest(matrix));
    }

    private static int findBiggest(int[][] arr) {
        int max = 0;
        for (int[] ints : arr) {
            for (int anInt : ints) {
                if (max < anInt) {
                    max = anInt;
                }
            }
        }
        return max;
    }
}
