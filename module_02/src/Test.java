import java.util.Arrays;
import java.util.TreeSet;

public class Test {
//    public static void main(String[] args) {
//        String s1= "aabcc";
//        String s2 = "adcaa";
//        int count = 0;
//        boolean[] t = new boolean[s2.length()];
//        for(int i = 0; i < s1.length(); i++) {
//            for (int j = 0; j < s2.length(); j++) {
//                if (s1.charAt(i) == s2.charAt(j) && !t[j]) {
//                    t[j] = true;
//                    count++;
//                    break;
//                }
//            }
//        }
//        System.out.println(count);
//        System.out.println(differentSubstringsTrie("abac"));
//
//    }

    static int differentSubstringsTrie(String inputString) {
        TreeSet<String> list = new TreeSet<>();
        for(int i = 1 ; i <= inputString.length() ; i++){
            for(int j = 0 ; j < inputString.length() - i + 1 ; j++){
                String temp = "";
                for(int k = j ; k < j + i ; k++){
                    temp += inputString.charAt(k);
                }
                list.add(temp);
            }
        }
        return list.size();
    }

    private static boolean checkEqualFrequency(int[] inputArray) {

        int numberOfEqual = 1;

        Arrays.sort(inputArray);

        while (numberOfEqual < inputArray.length
                && inputArray[numberOfEqual - 1] == inputArray[numberOfEqual]) {
            numberOfEqual++;
        }

        if ((inputArray.length % numberOfEqual) != 0) {
            return false;
        }

        for (int i = 0; i < inputArray.length; i += numberOfEqual) {
            if (i != 0 && inputArray[i] == inputArray[i - 1]) {
                return false;
            }
            for (int j = i + 1; j < i + numberOfEqual; j++) {
                if (inputArray[j] != inputArray[j - 1]) {
                    return false;
                }
            }
        }
        return true;
    }

    public static void main(String[] args) {
        int[] input =  {1, 1, 1, 2, 2, 3, 3, 3};
        System.out.println(checkEqualFrequency(input));
    }
}
