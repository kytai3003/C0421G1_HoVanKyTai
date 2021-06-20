package _11_Java_stack_queue.exercise.binary_stack;

import java.util.Scanner;
import java.util.Stack;

public class Binary {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Stack<Integer> binary = new Stack<>();

        System.out.println("Nhập số thập phân: ");
        int input = scanner.nextInt();

        while (input != 0) {
            int result = input % 2;
            binary.push(result);
            input /= 2;
        }

        int size = binary.size();
        System.out.println(binary);

        System.out.println("Số nhị phân tương ứng là: ");
        for (int i = 0; i < size; i++) {
            System.out.println(binary.pop());
        }

    }
}
