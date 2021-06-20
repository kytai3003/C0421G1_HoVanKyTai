package _11_Java_stack_queue.exercise.wordcount_treemap;

import java.util.ArrayList;
import java.util.Scanner;
import java.util.TreeMap;

class WordCount {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Tạo chuỗi
        System.out.println("Nhập chuỗi: ");
        String input = scanner.nextLine();

        // toLowerCase
        String lowerInput = input.toLowerCase();

        // Chuyển chuỗi thành List và xóa khoảng trắng
        String[] inputArr = new String[0];
        ArrayList<String> list = new ArrayList<>();

        if (input.equals("")) {
            System.out.println("Chuỗi rỗng.");
        } else {
            inputArr = lowerInput.split(" ");
            for (int i = 0; i < inputArr.length; i++) {
                if (!inputArr[i].isEmpty()) {
                    list.add(inputArr[i]);
                }
            }
        }

        // Hiển thị List
        System.out.println(list);
        System.out.println(list.size());


        // Tạo TreeMap
        TreeMap<String, Integer> treeMap = new TreeMap<>();
        for (int i = 0; i < list.size(); i++) {
            if (treeMap.containsKey(list.get(i))) {
                int count = treeMap.get(list.get(i)) + 1;
                treeMap.put(list.get(i), count);
            } else {
                treeMap.put(list.get(i), 1);
            }
        }
        System.out.println(treeMap);
    }
}
