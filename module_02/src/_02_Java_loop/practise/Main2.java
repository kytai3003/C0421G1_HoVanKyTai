package _02_Java_loop.practise;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        double money = 1.0;
        int month = 1;
        double interestRate = 1.0;
        System.out.println("Nhập số tiền muốn vay:");
        money = input.nextDouble();
        System.out.println("Nhập số tháng vay:");
        month = input.nextInt();
        System.out.println("Nhập lãi suất hàng năm: ");
        interestRate = input.nextDouble();

        double totalInterest = 0;
        for(int i = 0; i < month; i++){
            totalInterest += money * (interestRate/100)/12 * month;
        }

        System.out.println("Tổng tiền lãi phải trả là: " + totalInterest);
    }
}
