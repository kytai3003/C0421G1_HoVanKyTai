package _03_Java_array_method.practice;

import java.util.Scanner;

public class Main2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] students = {"Christian", "Michael", "Camila", "Sienna", "Tanya", "Connor",
                                        "Zachariah", "Mallory", "Zoe", "Emily"};
        System.out.print("Enter a name’s student:");
        String input_name = scanner.nextLine();

        boolean isExist = false;
        for (int i = 0; i < students.length; i++) {
            if (students[i].equals(input_name)) {
                System.out.println("Position of the students in the list " + input_name + " is: " + (i + 1));
                isExist = true;
                break;
            }
        }
        if (isExist == false) {
            System.out.println("Not found" + input_name + " in the list.");
        }
    }
}
