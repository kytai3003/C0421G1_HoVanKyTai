package _03_Java_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class CharacterFrequency {
    public static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        // Nhập chuỗi
        System.out.println("Nhập chuỗi: ");
        String input = scanner.nextLine();

        // Chuyển chuỗi thành mảng kí tự
        char[] inp = input.toCharArray();
        System.out.println(Arrays.toString(inp));

        //Nhập kí tự kiểm tra X
        System.out.println("Nhập kí tự muốn kiểm tra:");
        char x = scanner.next().charAt(0);
        int count = 0;

        // Duyệt mảng
        for (int i = 0; i < inp.length; i++) {
            if (inp[i] == x) {
                count++;
            }
        }
        System.out.println("Số lần xuất hiện ký tự " + x + " là " + count);
    }
}
