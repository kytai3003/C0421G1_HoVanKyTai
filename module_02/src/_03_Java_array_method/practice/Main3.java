package _03_Java_array_method.practice;

import java.util.Scanner;

public class Main3 {
    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        int size;

        do {
            System.out.print("Enter a size:");
            size = scanner.nextInt();
            if (size > 20)
                System.out.println("Size should not bigger than 20");
        } while (size > 20);

        int[] array = new int[size];
        int i = 0;

        while (i < array.length) {
            System.out.println("Enter element " + (i+1) + ":");
            array[i] = scanner.nextInt();
            i++;
        }

        for (int x : array) {
            System.out.print(x + " ");
        }

        int max = array[0];
        int index = 1;
        for (int j = 0; j < array.length; j++) {
            if (array[j] > max) {
                max = array[j];
                index = j + 1;
            }
        }

        System.out.println("The biggest element is " + max + " ,at position " + index);
    }
}
