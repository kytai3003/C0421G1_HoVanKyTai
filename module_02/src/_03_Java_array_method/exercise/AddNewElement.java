package _03_Java_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class AddNewElement {

    private static Scanner scanner = new Scanner(System.in);

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

        // Insert X vào mảng
        System.out.println("Nhập giá trị cần chèn: ");
        int x = scanner.nextInt();
        System.out.println("Nhập vị trí muốn chèn:");
        int index = scanner.nextInt();
        if (index <= 1 || index > number.length - 1) {
            System.out.println("Không thể chèn");
        } else {
            int temp = 0;
            for (int i = number.length - 1; i > index; i--) {
                number[i] = number[i - 1];
            }
            number[index] = x;
        }

        // Hiển thị lại mảng đã thêm X
        for (int a: number) {
            System.out.println(a);
        }
    }
}
