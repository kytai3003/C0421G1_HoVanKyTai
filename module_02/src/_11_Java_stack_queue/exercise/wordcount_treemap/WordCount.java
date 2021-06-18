package _11_Java_stack_queue.exercise.wordcount_treemap;

import java.util.Scanner;
import java.util.TreeMap;

class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Nhập chuỗi: ");
        String input = scanner.nextLine();

        // toLowerCase
        String lowerInput = input.toLowerCase();

        // Chuyển chuỗi thành mảng
        String[] inputArr = new String[0];
        if (input.equals("")) {
            System.out.println("Chuỗi rỗng.");
        } else {
            inputArr = lowerInput.split(" ");
        }
        
        // Hiển thị mảng chuỗi
        for (String x : inputArr) {
            System.out.println(x);
        }

        // Tạo TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<String, Integer>();

        for (int i = 0; i < inputArr.length; i++) {
            if (treeMap.containsKey(inputArr[i])) {
                int count = treeMap.get(inputArr[i]) + 1;
                treeMap.put(inputArr[i], count);
            } else {
                treeMap.put(inputArr[i], 1);
            }
        }
        System.out.println(treeMap);
    }
}
