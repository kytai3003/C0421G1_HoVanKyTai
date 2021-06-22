package _11_Java_stack_queue.exercise.bracket_check;

import java.util.Scanner;
import java.util.Stack;

public class Bracket {
    static char left;
    public static boolean checkBracket(String str) {
        Stack<Character> bStack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            left = str.charAt(i);
            if (left == '(') {
                bStack.push(left);
            } else if (left == ')') {
                if (bStack.isEmpty()) {
                    return false;
                } else {
                    bStack.pop();
                }
            }
        }
        return bStack.isEmpty();
    }

    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String string = input.nextLine();
        System.out.println(checkBracket(string));
    }
}

