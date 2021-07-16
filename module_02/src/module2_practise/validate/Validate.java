package module2_practise.validate;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validate {
    static Scanner sc = new Scanner(System.in);
    public String legalServiceBasicInfo() {
        String legalType = "[A-Z][a-zA-z0-9]*";
        boolean check = false;
        String stringType = "";
        while (!check) {
            stringType = sc.nextLine();
            check = Pattern.matches(legalType, stringType);
            if (check && stringType.trim().length() > 0) {
                System.out.println("Ok.");
            } else {
                System.err.println("Viết hoa chữ đầu và không được để trống.");
                check = false;
            }
        }
        return stringType;
    }

    public int legalNumberField() {
        boolean check = false;
        int number = 0;
        while (!check) {
            number = Integer.parseInt(sc.nextLine());
            if (number > 0) {
                check = true;
                System.out.println("Ok.");
            } else {
                System.err.println("Nhập số lớn hơn 0.");
            }
        }
        return number;
    }
}
