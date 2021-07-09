package resort_management.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class DayOfBirthRegex {
    private static final Scanner sc = new Scanner(System.in);
    public String legalDayOfBirth() {
        String legalRegex = "^\\d{1,2}[/]\\d{1,2}[/]\\d{4}$";
        boolean check = false;
        String stringDob = "";
        while (!check) {
            stringDob = sc.nextLine();
            if (stringDob.length() > 10) {
                System.err.println("Wrong format. Retry");
            } else if (stringDob.length() < 10) {
                System.err.println("Wrong format. Retry");
            } else {
                String[] arrDob = stringDob.split("/");
                int day = Integer.parseInt(arrDob[0]);
                int month = Integer.parseInt(arrDob[1]);
                int year = Integer.parseInt(arrDob[2]);
                check = Pattern.matches(legalRegex, stringDob);
                if (check) {
                    if (day > 0 && day <= 31 && month > 0 && month <= 12 && year > 1921 && year <= 2003) {
                        System.out.println("Success.");
                        check = true;
                    } else {
                        System.err.println("Input false. Retry");
                        check = false;
                    }
                } else {
                    System.err.println("Input false. Retry");
                }
            }
        }
        return stringDob;
    }
}
