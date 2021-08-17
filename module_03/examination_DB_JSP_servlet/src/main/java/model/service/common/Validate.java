package model.service.common;

public class Validate {
    public static String validateNumber(int number) {
        String message = null;
        if (number < 0) {
            message = "Not OK. Number must be > 0";
        }
        return message;
    }

}
