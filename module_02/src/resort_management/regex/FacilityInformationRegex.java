package resort_management.regex;

import java.util.Scanner;
import java.util.regex.Pattern;

public class FacilityInformationRegex {
    private static final Scanner sc = new Scanner(System.in);

//    -	Mã dịch vụ phải đúng định dạng: SVXX-YYYY, với YYYY là các số từ 0-9, XX là:
//    -	Nếu là Villa thì XX sẽ là VL
    public String codeVilla() {
        String legalCodeVilla = "(SVVL)[-][\\d]{4}";
        boolean check = false;
        String stringCode = "";
        while (!check) {
            System.out.println("Villa ID format: SVVL-xxxx (number chain).Input: ");
            stringCode = sc.nextLine();
            check = Pattern.matches(legalCodeVilla, stringCode);
            if (check) {
                System.out.println("Success.");
            } else {
                System.err.println("Input false. Retry.");
            }
        }
        return stringCode;
    }

//    -	Nếu là House thì XX sẽ là HO
    public String codeHouse() {
        String legalCodeHouse = "(SVHO)[-][\\d]{4}";
        boolean check = false;
        String stringCode = "";
        while (!check) {
            System.out.println("House ID format: SVHO-xxxx (number chain).Input: ");
            stringCode = sc.nextLine();
            check = Pattern.matches(legalCodeHouse, stringCode);
            if (check) {
                System.out.println("Success.");
            } else {
                System.err.println("Input false. Retry.");
            }
        }
        return stringCode;
    }

//    -	Nếu Room thì XX sẽ là RO
    public String codeRoom() {
        String legalCodeRoom = "(SVRO)[-][\\d]{4}";
        boolean check = false;
        String stringCode = "";
        while (!check) {
            System.out.println("Room ID format: SVRO-xxxx (number chain).Input: ");
            stringCode = sc.nextLine();
            check = Pattern.matches(legalCodeRoom, stringCode);
            if (check) {
                System.out.println("Success.");
            } else {
                System.err.println("Input false. Retry.");
            }
        }
        return stringCode;
    }

//     - Tên dịch vụ phải viết hoa ký tự đầu, các ký tự sau là ký tự bình thường
    public String legalServiceBasicInfo() {
        String legalType = "[A-Z][a-zA-z]*";
        boolean check = false;
        String stringType = "";
        while (!check) {
            stringType = sc.nextLine();
            check = Pattern.matches(legalType, stringType);
            if (check && stringType.trim().length() > 0) {
                System.out.println("Success.");
            } else {
                System.err.println("Input false. Retry.");
                check = false;
            }
        }
        return stringType;
    }

    public String legalNumberField() {
        boolean check = false;
        String stringNumber = "";
        while (!check) {
            stringNumber = sc.nextLine();
            if (stringNumber.length() > 0) {
                check = true;
                System.out.println("Success.");
            } else {
                System.err.println("Input false. Retry.");
            }
        }
        return stringNumber;
    }

    public String legalLivingAndPoolArea() {
        String stringArea = "";
        int area = 0;
        boolean check = false;
        while (!check) {
            stringArea = sc.nextLine();
                try {
                    area = Integer.parseInt(stringArea);
                } catch (NumberFormatException e) {
                    System.err.println("Input number only");
                }
            if (area < 30) {
                System.err.println("Input false. Retry.");
            } else {
                System.out.println("Success.");
                check = true;
            }
        }
        return stringArea;
    }

    public String legalPriceAndLevel() {
        String stringPrice = "";
        double price = 0;
        boolean check = false;
        while (!check) {
            stringPrice = sc.nextLine();
            try {
                price = Integer.parseInt(stringPrice);
            } catch (NumberFormatException e) {
                System.err.println("Input number only");
            }
            if (price <= 0) {
                System.err.println("Input false. Retry.");
            } else {
                System.out.println("Success.");
                check = true;
            }
        }
        return stringPrice;
    }

    public String legalCapacity() {
        String stringCapacity = "";
        int capacity = 0;
        boolean check = false;
        while (!check) {
            stringCapacity = sc.nextLine();
            try {
                capacity = Integer.parseInt(stringCapacity);
            } catch (NumberFormatException e) {
                System.err.println("Input number only");
            }
            if (capacity <= 0 || capacity > 20) {
                System.err.println("Input false. Retry.");
            } else {
                System.out.println("Success.");
                check = true;
            }
        }
        return stringCapacity;
    }
}
