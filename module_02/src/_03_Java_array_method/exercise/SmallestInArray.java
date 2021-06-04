package _03_Java_array_method.exercise;

import java.util.Scanner;

public class SmallestInArray {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Nhập kích thước mảng
        System.out.println("Nhập số lượng phần tử:");
        int size = scanner.nextInt();
        int[] number = new int[size];
        //Nhập phần tử
        for (int i = 0; i < number.length; i++) {
            System.out.println("Nhập phần tử thứ " + (i + 1) + " của mảng");
            number[i] = scanner.nextInt();
        }
        // Hiển thị mảng
        for (int a : number) {
            System.out.println(a);
        }

        //  Duyệt mảng và tìm GTNN
        System.out.println("Giá trị nhỏ nhất trong mảng là: " + smallestNumb(number));

    }

    private static int smallestNumb(int[] arr) {
        int min = arr[0];
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return min;
    }
}
