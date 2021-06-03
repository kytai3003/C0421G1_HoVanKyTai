package _02_Java_loop.practise;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Enter a number:");
        int number = scanner.nextInt();
        if (number <= 2) {
            System.out.println(number + " không phải số nguyên tố");
        } else {
            int count = 0;
            for (int i = 1; i <= number; i++) {
                if (number % i == 0) {
                    count += 1;
                }
            }
            if (count == 2) {
                System.out.println(number + " là số nguyên tố");
            } else {
                System.out.println(number + " không phải số nguyên tố");
            }
        }
    }
}