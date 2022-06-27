package _02_Java_loop.exercise;

public class PrimeNumberSmallerThan100 {

    public static void primeNumbersSmallerThanN(int n) {
        int run = 2;
        while (true) {
            int count = 0;
            for (int i = 1; i <= run; i++) {
                if (run % i == 0) {
                    count++;
                }
            }
            if (count == 2) {
                System.out.println(run);
            }
            if (run >= n) {
                break;
            }
            run++;
        }
    }


    public static String concatString(String s1, String s2) {
        if (s1.charAt(s1.length() - 1) == '0') {
            s1 = s1.substring(0, s1.length() - 1);
        }

        return new String(s1 + "." + s2);
    }

    public static void main(String[] args) {
        int a = 1234;
        String b = String.valueOf(a);
        System.out.println(b);
        System.out.println(concatString("12340", "test1"));
    }
}

