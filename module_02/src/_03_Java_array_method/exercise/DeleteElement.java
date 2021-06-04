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
        int index = 0;
        boolean isExist = false;
        for (int i = 0; i < number.length; i++) {
            if (x == number[i]) {
                isExist = true;
                index = i;
            }
        }
        if (!isExist) {
            System.out.println("Không tìm thấy giá trị X trong mảng.");
        } else {
            System.out.println("Tìm thấy giá trị của X tại vị trí: " + index);
            for (int i = index; i < number.length - 1; i++) {
                number[i] = number[i + 1];
            }
            number[number.length - 1] = 0;

            // Hiển thị lại mảng đã xóa X
            for (int a: number) {
                System.out.println(a);
            }
        }
    }
}
