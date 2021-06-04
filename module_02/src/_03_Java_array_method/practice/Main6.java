package _03_Java_array_method.practice;

import java.util.Scanner;

public class Main6 {
    public static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("Nhập kích thước mảng (không vượt quá 30):");
        int size = scanner.nextInt();
        int []mark = new int[size];

        for (int i = 0; i < mark.length; i++) {
            System.out.println("Nhập điểm học sinh thứ: " + (i+1));
            mark[i] = scanner.nextInt();
        }

        for (int x: mark) {
            System.out.println(x);
        }

        int count = 0;
        for (int i = 0; i < mark.length;i++) {
            if (mark[i] >=5 && mark[i] <=10) {
                count++;
            }
        }
        System.out.println("Số học sinh qua môn là " + count);
    }
}
