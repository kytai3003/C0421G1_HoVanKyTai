package _13_Java_searching_algorithm.exercise;

import java.util.LinkedList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);

        System.out.print("Nhập chuỗi: ");
        String string = input.nextLine();
        //Khai báo một linked list chính để hiển thị kết quả
        LinkedList<Character> max = new LinkedList<>();
        //Khai báo một linked list trung gian để thao tác
        LinkedList<Character> list = new LinkedList<>();

        // Thêm kí tự vào list trung gian
        for (int i = 0; i < string.length(); i++) {
            list.add(string.charAt(i));
            for (int j = i + 1; j < string.length(); j++) {
                if (string.charAt(j) > list.getLast()) {
                    list.add(string.charAt(j));
                }
            }
            if (list.size() > max.size()) {
                max.clear();
                max.addAll(list);
            }
            list.clear();
        }

        // Hiển thị chuỗi tăng dần dài nhất
        for (Character ch : max) {
            System.out.print(ch);
        }
        System.out.println();
    }
}