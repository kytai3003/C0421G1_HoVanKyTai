package model.service.common;

public class Validate {
    public static String validateNumber(int number) {
        String message = null;
        if (number < 0) {
            message = "Not OK. Number must be > 0";
        }
        return message;
    }

    public static String validateEmail(String email) {
        String message = null;
        String regexCode = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
        if (!email.matches(regexCode)) {
            message = "Wrong format email. Retry.";
        }
        return message;
    }

    public static String validatePhone(String phoneNumber) {
        String message = null;
        String regexPhoneNumber ="^((\\(84\\)\\+(090))|(090)|(091)|(\\(84\\)\\+(091)))[\\d]{7}$";
        if (!phoneNumber.matches(regexPhoneNumber)) {
            message = "Wrong format phone number. Retry.";
        }
        return message;
    }

    public static String validateIdCard(String idCard) {
        String message = null;
        String regexIdCard = "^[\\d]{9}$";
        if (!idCard.matches(regexIdCard)) {
            message = "Wrong format ID card. Retry.";
        }
        return message;
    }
}
