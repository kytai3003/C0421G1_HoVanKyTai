package _03_Java_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class DeleteElement {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {

        // Khởi tạo mảng
        System.out.println("Nhập số lượng phần tử:");
        int size = scanner.nextInt();
        int[] number = new int[size];
        for (int i = 0; i < number.length; i++) {
            System.out.println("Nhập phần tử thứ " + (i+1));
            number[i] = scanner.nextInt();
        }

        // Hiển thị mảng
        System.out.println(Arrays.toString(number));

        // Nhập X và xóa X trong mảng
        System.out.println("Nhập phần tử muốn xóa: ");
        int x = scanner.nextInt();
        boolean isExist = false;
        for (int i = 0; i < number.length; i++) {
            if (x == number[i]) {
                isExist = true;
                for (int j = i; j < number.length - 1; j++) {
                    number[j] = number[j + 1];
                    number[j + 1] = 0;
                }
            }
        }
        if (!isExist) {
            System.out.println("Không tìm thấy giá trị X trong mảng.");
        }

            // Hiển thị lại mảng đã xóa X
            for (int a: number) {
                System.out.println(a);
            }
        }
    }