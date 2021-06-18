package _11_Java_stack_queue.exercise.reverse_stack;
import java.util.Arrays;
import java.util.Stack;

public class ReverseStack {
    public static void main(String[] args) {

        // Khởi tạo mảng số nguyên
        int []numb = {1,3,5,7,9};
        System.out.println("Chưa đảo ngược: " + Arrays.toString(numb));

        // Khởi tạo stack kiểu số nguyên
        Stack<Integer> number = new Stack<>();

        // Thêm từ mảng vào stack
        for (int i = 0; i < numb.length; i++) {
            number.push(numb[i]);
        }

        // Thêm ngược lại vào mảng
        for (int i = 0; i < numb.length; i++) {
            numb[i] = number.pop();
        }
        System.out.println("Đã đảo ngược: " + Arrays.toString(numb));

        // Khởi tạo chuỗi
        String str = "CodeGym Đà Nẵng Nguyễn Tất Thành";
        Stack<String> mStack = new Stack<>();

        // Chuyển chuỗi thành mảng
        String[] strArr = str.split(" ");
        System.out.println("Chưa đảo ngược: " + Arrays.toString(strArr));

        // Thêm từ mảng chuỗi vào stack
        for (int i = 0; i < strArr.length; i++) {
            mStack.push(strArr[i]);
        }

        // Thêm ngược lại vào mảng
        for (int i = 0; i < strArr.length; i++) {
            strArr[i] = mStack.pop();
        }
        System.out.println("Đã đảo ngược: " + Arrays.toString(strArr));
    }
}
