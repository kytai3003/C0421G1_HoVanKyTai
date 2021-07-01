package _19_Java_string_regex.exercise;

import java.util.Scanner;

public class ValidateClassName {
    private static final String VALID_CLASS_NAME = "^[CAP][0-9]{4}[GHIKLM]$";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isLegal = false;
        while(!isLegal) {
            System.out.println("Input class name: ");
            String input = sc.nextLine();
            if (input.matches(VALID_CLASS_NAME)) {
                isLegal = true;
                System.out.println("Valid.");
            } else {
                System.out.println("Invalid. Retry");
            }
        }
    }
}
