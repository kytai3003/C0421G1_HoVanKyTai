package _01_introduction_to_Java.practise;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        float width;
        float height;

        Scanner scanner = new Scanner(System.in);

        System.out.println("Enter width: ");
        width = scanner.nextFloat();

        System.out.println("Enter height: ");
        height = scanner.nextFloat();

        float area = height * width;
        System.out.println("Area is: " + area);
    }
}
