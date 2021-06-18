package _11_Java_stack_queue.exercise.palindrome;

import java.util.ArrayDeque;
import java.util.Stack;

public class PalindromeTest {
    public static void main(String[] args) {
        String str = "Able was I ere I saw Elba";
        String input = str.toLowerCase();
        String[] inputArr = input.split("");

        Stack<String> stack = new Stack();
        ArrayDeque<String> queue = new ArrayDeque<>();

        for (int i = 0; i < inputArr.length; i++) {
            stack.push(inputArr[i]);
            queue.offer(inputArr[i]);
        }

        System.out.println(stack);
        System.out.println(queue);

        int count = 0;
        for (int i = 0; i < inputArr.length; i++) {
            if(stack.pop().equals(queue.poll())) {
                count++;
            }
        }
        if (count == inputArr.length) {
            System.out.println("True");
        } else {
            System.out.println("False");
        }
    }
}