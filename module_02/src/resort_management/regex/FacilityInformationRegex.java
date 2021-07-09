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
            if (check) {
                System.out.println("Success.");
            } else {
                System.err.println("Input false. Retry.");
            }
        }
        return stringType;
    }

    public String legalLivingAndPoolArea() {
        String area = "";
        boolean check = false;
        while (!check) {
                area = sc.nextLine();
            if (Integer.parseInt(area) < 30) {
                System.err.println("Input false. Retry.");
            } else {
                System.out.println("Success.");
                check = true;
            }
        }
        return area;
    }

    public String legalPriceAndLevel() {
        String price = "";
        boolean check = false;
        while (!check) {
                price = sc.nextLine();
            if (Integer.parseInt(price) < 0) {
                System.err.println("Input false. Retry.");
            } else {
                System.out.println("Success.");
                check = true;
            }
        }
        return price;
    }

    public String legalCapacity() {
        String capacity = "";
        boolean check = false;
        while (!check) {
            capacity = sc.nextLine();
            if (Integer.parseInt(capacity) < 0 || Integer.parseInt(capacity) > 20) {
                System.err.println("Input false. Retry.");
            } else {
                System.out.println("Success.");
                check = true;
            }
        }
        return capacity;
    }
}
