package student_management;

import java.util.Scanner;
import java.util.TreeMap;

public class Main {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String args[]) throws Exception {
        TreeMap<Integer, String> list = new TreeMap<>();
        list.put(1, "Nguyen Van A");
        list.put(2, "Nguyen Van B");
        list.put(3, "Nguyen Van C");
        list.put(4, "Nguyen Van D");
        list.put(5, "Nguyen Van E");
        changeName(list, "Nguyen Van C");
        System.out.println("Đã thay đổi: " + list.entrySet());
    }

    public static void changeName(TreeMap<Integer, String> map, String name) {
        boolean checkValid = false;
        String newName;
        while (!checkValid) {
            try {
                System.out.println("Mời nhập tên");
                newName = scanner.nextLine();
                if (newName.length() < 5) {
                    throw new StringException("Nhập tên quá ngắn. Mời nhập lại");
                } else if (newName.length() > 20) {
                    throw new StringException("Nhập tên quá dài. Mời nhập lại");
                }
                else {
                    for (int i = 1; i <= map.size(); i++) {
                        if (map.get(i).equals(name)) {
                            map.put(i, newName);
                            break;
                        }
                    }
                    checkValid = true;
                }
            } catch (StringException e) {
                System.out.println(e.getMessage());
            }
        }
    }
}
