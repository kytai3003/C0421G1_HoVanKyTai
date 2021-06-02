package _01_introduction_to_Java.exercise;

import com.sun.xml.internal.ws.api.model.wsdl.WSDLOutput;

import java.util.Scanner;

public class CountInWord {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Input hundred: ");
        int hundred = scanner.nextInt();
        System.out.print("Input teens: ");
        int teen = scanner.nextInt();
        System.out.print("Input ones: ");
        int one = scanner.nextInt();
        int number = hundred * 100 + teen * 10 + one;
        String x = "";
            switch (hundred) {
                case 1:
                    x = "one hundred and";
                    break;
                case 2:
                    x = "two hundred and";
                    break;
                case 3:
                    x = "three hundred and";
                    break;
                case 4:
                    x = "four hundred and";
                    break;
                case 5:
                    x = "five hundred and";
                    break;
                case 6:
                    x = "six hundred and";
                    break;
                case 7:
                    x = "seven hundred and";
                    break;
                case 8:
                    x = "eight hundred and";
                    break;
                case 9:
                    x = "nine hundred and";
                    break;
                case 0:
                    x = " ";
                    break;
            }

            String y = "";
            switch (teen) {
                case 2:
                    y = " twenty";
                    break;
                case 3:
                    y = " thirty";
                    break;
                case 4:
                    y = " fourty";
                    break;
                case 5:
                    y = " fifty";
                    break;
                case 6:
                    y = " sixty";
                    break;
                case 7:
                    y = " seventy";
                    break;
                case 8:
                    y = " eighty";
                    break;
                case 9:
                    y = " ninety";
                    break;
                case 0:
                    y = "";
                    break;
            }

            String z = "";
            switch (one) {
                case 1:
                    z = " one";
                    break;
                case 2:
                    z = " two";
                    break;
                case 3:
                    z = " three";
                    break;
                case 4:
                    z = " four";
                    break;
                case 5:
                    z = " five";
                    break;
                case 6:
                    z = " six";
                    break;
                case 7:
                    z = " seven";
                    break;
                case 8:
                    z = " eight";
                    break;
                case 9:
                    z = " nine";
                    break;
                case 0:
                    z = "";
                    break;
            }

        String result = "";
        int special = teen * 10 + one;
            if (special >= 10 && special < 20) {
                switch (special) {
                    case 10:
                        result = x + " ten";
                        System.out.printf(result);
                        break;
                    case 11:
                        result = x + " eleven";
                        System.out.printf(result);
                        break;
                    case 12:
                        result = x + " twelve";
                        System.out.printf(result);
                        break;
                    case 13:
                        result = x + " thirteen";
                        System.out.printf(result);
                        break;
                    case 14:
                        result = x + " fourteen";
                        System.out.printf(result);
                        break;
                    case 15:
                        result = x + " fifteen";
                        System.out.printf(result);
                        break;
                    case 16:
                        result = x + " sixteen";
                        System.out.printf(result);
                        break;
                    case 17:
                        result = x + " seventeen";
                        System.out.printf(result);
                        break;
                    case 18:
                        result = x + " eightteen";
                        System.out.printf(result);
                        break;
                    case 19:
                        result = x + " nineteen";
                        System.out.printf(result);
                        break;
                }
            } else {
                result = x + y + z;
                System.out.printf(result);
            }
        }
    }
