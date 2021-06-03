package _02_Java_loop.exercise;

import java.util.Scanner;

public class DisplayShape {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int choice = -1;

        while (choice != 0) {
            System.out.println("1. Print the rectangle");
            System.out.println("2. Print the square triangle (4 shapes)");
            System.out.println("3. Print isosceles triangle");
            System.out.println("0. Exit");
            choice = input.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Input length: ");
                    int length = input.nextInt();
                    System.out.println("Input width: ");
                    int width = input.nextInt();

                    for (int i = 0; i < length; i++) {
                        for (int j = 0; j < width; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    break;


                case 2:
                    System.out.println("Input height: ");
                    int height = input.nextInt();
                    for (int i = 0; i < height; i++) {
                        for (int j = 0; j <= i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    System.out.println("");

                    for (int i = height; i > 0; i--) {
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println("");
                    }
                    System.out.println("");

                    for (int i = 0; i <= height; i++) {
                        for (int j = height; j > i; j--) {
                            System.out.print(" ");
                        }
                        for (int j = 0; j < i; j++) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    System.out.println("");

                    for (int i = 0; i <= height; i++) {
                        for (int j = 0; j < i; j++) {
                            System.out.print(" ");
                        }
                        for (int j = height; j > i; j--) {
                            System.out.print("*");
                        }
                        System.out.println();
                    }
                    break;

                case 3:
                    System.out.println("Input height: ");
                    int h = input.nextInt();
                    for (int i = 0; i <= h; i++) {

                        for (int j = h; j > i; j--) {
                            System.out.print(" ");
                        }

                        for (int j = 0; j < i; j++) {
                            System.out.print("* ");
                        }
                        System.out.println();
                    }
                    break;

                case 0:
                    System.exit(0);

                default:
                    System.out.println("Input again");
            }
        }
    }
}