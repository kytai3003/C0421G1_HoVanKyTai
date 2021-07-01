package _19_Java_string_regex.exercise;

import java.util.Scanner;

public class ValidatePhoneNumber {
    private static final String VALID_PHONE_NUMBER = "^[(]{1}[0-9]{2}[)]{1}[-]{1}[(]{1}[0]{1}[0-9]{9}[)]{1}$";
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        boolean isLegal = false;
        while(!isLegal) {
            System.out.println("Input phone number: ");
            String input = sc.nextLine();
            if (input.matches(VALID_PHONE_NUMBER)) {
                isLegal = true;
                System.out.println("Valid.");
            } else {
                System.out.println("Invalid. Retry");
            }
        }
    }
}
