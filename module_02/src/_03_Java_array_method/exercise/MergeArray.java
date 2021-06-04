package _03_Java_array_method.exercise;

import java.util.Arrays;
import java.util.Scanner;

public class MergeArray {

        private static Scanner scanner = new Scanner(System.in);

        public static void main(String[] args) {
            // Input mảng 1
            System.out.println("Nhập số lượng phần tử mảng 1:");
            int size1 = scanner.nextInt();
            int[] number1 = new int[size1];
            for (int i = 0; i < number1.length; i++) {
                System.out.println("Nhập phần tử thứ " + (i+1) + " của mảng 1.");
                number1[i] = scanner.nextInt();
            }
            for (int a : number1) {
                System.out.println(a);
            }

            // Input mảng 2
            System.out.println("Nhập số lượng phần tử mảng 2:");
            int size2 = scanner.nextInt();
            int[] number2 = new int[size2];
            for (int i = 0; i < number2.length; i++) {
                System.out.println("Nhập phần tử thứ " + (i+1) + " của mảng 2.");
                number2[i] = scanner.nextInt();
            }
            for (int b : number2) {
                System.out.println(b);
            }

            // Input mảng 3
            int size3 = size1 + size2;
            int[] number3 = new int[size3];
            for (int i = 0; i < number1.length; i++) {
                number3[i] = number1[i];
            }
            for (int i = 0; i < number2.length; i++) {
                number3[number1.length + i] = number2[i];
            }
            System.out.println("Mảng 3: ");
            for (int c : number3) {
                System.out.println(c);
            }
        }
    }

