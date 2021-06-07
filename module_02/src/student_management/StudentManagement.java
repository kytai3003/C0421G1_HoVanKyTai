package student_management;

import java.util.Scanner;

public class StudentManagement {
    public static Scanner scanner =  new Scanner(System.in);
    public static void main(String[] args) {
        System.out.println("-------------------Chương trình quản lý sinh viên------------------");
        Student []students = new Student[50];
        while (true) {
            System.out.println("Menu chương trình");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Xóa sinh viên");
            System.out.println("3. Chỉnh sửa thông tin sinh viên");
            System.out.println("4. Thêm mới sinh viên");
            System.out.println("5. Thoát chương trình");
            System.out.println("Chọn chức năng muốn sử dụng");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayStudent(students);
                    break;

                case 2:
                    deleteStudent(students);
                    break;

                case 3:
                    editStudent(students);
                    break;

                case 4:
                    creatNewStudent(students);
                    break;

                case 5:
                    System.exit(1);
                    break;

                default:
                    System.out.println("Mời nhập lại.");
            }
        }
    }

    private static void displayStudent (Student[] students) {
        for (Student student : students) {
            if (student != null) {
                System.out.println(student);
            }
        }
    }

    private static void deleteStudent (Student[] students) {
        System.out.println("Nhập id sinh viên muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < students.length; i++) {
            if (students[i].getId() == id) {
                students[i].setName(null);
                students[i].setAddress(null);
                students[i].setAge(0);
                students[i].setId(0);
                break;
            }
        }
    }

    private static void creatNewStudent (Student[] students) {
        System.out.println("Nhập id cho sinh viên mới: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sinh viên mới: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên mới: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập địa chỉ sinh viên mới: ");
        String address = scanner.nextLine();
        Student newStudent = new Student(id, name, age, address);
        for (int i = 0; i < students.length; i++) {
            if (students[i] == null) {
                students[i] = newStudent;
                break;
            }
        }
    }

    private static void editStudent (Student[] students) {
        System.out.println("Nhập id sinh viên muốn sửa thông tin: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mục thông tin muốn chỉnh sửa: ");
        System.out.println("1. Sửa id");
        System.out.println("2. Sửa tên");
        System.out.println("3. Sửa tuổi");
        System.out.println("4. Sửa địa chỉ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Nhập id mới: ");
                int newId = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < students.length; i++) {
                    if (students[i].getId() == id) {
                        students[i].setId(newId);
                        break;
                    } else if (newId == id) {
                        System.out.println("Id đã bị trùng");
                        students[i].setId(id);
                        break;
                    }
                }
                break;

            case 2:
                System.out.println("Nhập tên mới: ");
                String newName = scanner.nextLine();
                for (int i = 0; i < students.length; i++) {
                    if (id == students[i].getId()) {
                        students[i].setName(newName);
                        break;
                    }
                }
                break;

            case 3:
                System.out.println("Nhập tuổi mới: ");
                int newAge = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < students.length; i++) {
                    if (id == students[i].getId()) {
                        students[i].setAge(newAge);
                        break;
                    }
                }
                break;

            case 4:
                System.out.println("Nhập địa chỉ mới: ");
                String newAddress = scanner.nextLine();
                for (int i = 0; i < students.length; i++) {
                    if (id == students[i].getId()) {
                        students[i].setAddress(newAddress);
                        break;
                    }
                }
                break;

            default:
                System.out.println("Mời nhập lại");
        }
    }
}
