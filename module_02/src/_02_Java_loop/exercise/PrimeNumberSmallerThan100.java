package _02_Java_loop.exercise;

public class PrimeNumberSmallerThan100 {
    public static void main(String[] args) {
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
            if (run >= 100) {
                break;
            }
            run++;
        }
    }
}

