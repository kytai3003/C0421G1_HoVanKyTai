package _01_introduction_to_Java.exercise;

import java.util.Scanner;

public class Currency {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        double vnd = 23000;
        double usd;
        System.out.println("Nhập số tiền USD: ");
        usd = scanner.nextDouble();
        double quydoi = usd * vnd;
        System.out.println("Giá trị VNĐ: " + quydoi);
    }
}
