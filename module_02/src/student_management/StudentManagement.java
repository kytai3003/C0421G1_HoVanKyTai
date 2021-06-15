package student_management;

import java.util.Scanner;

public class StudentManagement {
    public static Scanner scanner =  new Scanner(System.in);
    public static Person[] people;
    static {
        people = new Person[50];
        people[0] = new Student(1, "Trung", 33, "Đà Nẵng", "C04");
        people[1] = new Student(2, "Nhật", 23, "Quảng Nam", "C04");
        people[2] = new Student(3, "Tài", 24, "Quảng Ngãi", "C04");
        people[3] = new Student(4, "Minh", 25, "Vinh", "C04");
        people[4] = new Teacher(5, "Tiến", 26, "Quảng Bình", "Master");
        people[5] = new Teacher(6, "Hải", 29, "Hà Nội", "Beginner");
    }
    public static void main(String[] args) {
        System.out.println("-------------------Chương trình quản lý sinh viên------------------");
        while (true) {
            System.out.println("Menu chương trình");
            System.out.println("1. Xem danh sách sinh viên");
            System.out.println("2. Xem danh sách giáo viên");
            System.out.println("3. Xóa sinh viên");
            System.out.println("4. Xóa giáo viên");
            System.out.println("5. Thêm mới sinh viên");
            System.out.println("6. Thêm mới giáo viên");
            System.out.println("7. Chỉnh sửa thông tin sinh viên");
            System.out.println("8. Chỉnh sửa thông tin giáo viên");
            System.out.println("9. Thoát chương trình");
            System.out.println("Chọn chức năng muốn sử dụng");
            int choice = Integer.parseInt(scanner.nextLine());

            switch (choice) {
                case 1:
                    displayListStudent(people);
                    break;

                case 2:
                    displayListTeacher(people);
                    break;

                case 3:
                    deleteStudent(people);
                    break;

                case 4:
                    deleteTeacher(people);
                    break;

                case 5:
                    creatNewStudent(people);
                    break;

                case 6:
                    creatNewTeacher(people);
                    break;

                case 7:
                    editStudent(people);
                    break;

                case 8:
                    editTeacher(people);
                    break;

                case 9:
                    System.exit(1);
                    break;

                default:
                    System.out.println("Mời nhập lại.");
            }
        }
    }

    public static void displayListStudent (Person[] people) {
        for (Person person : people) {
            if (person != null && person instanceof Student) {
                System.out.println(person);
            }
        }
    }

    public static void displayListTeacher (Person[] people) {
        for (Person person : people) {
            if (person != null && person instanceof Teacher) {
                System.out.println(person);
            }
        }
    }

    public static void deleteStudent (Person[] people) {
        System.out.println("Nhập id sinh viên muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId() == id && people[i] instanceof Student) {
                people[i] = new Student();
                break;
            }
        }
    }

    public static void deleteTeacher (Person[] people) {
        System.out.println("Nhập id giáo viên muốn xóa: ");
        int id = Integer.parseInt(scanner.nextLine());
        for (int i = 0; i < people.length; i++) {
            if (people[i].getId() == id && people[i] instanceof Teacher) {
                people[i] = new Teacher();
                break;
            }
        }
    }

    public static void creatNewStudent (Person[] people) {
        System.out.println("Nhập id cho sinh viên mới: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên sinh viên mới: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi sinh viên mới: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập địa chỉ sinh viên mới: ");
        String address = scanner.nextLine();
        System.out.println("Nhập lớp cho sinh viên mới: ");
        String _class = scanner.nextLine();
        Student newStudent = new Student(id, name, age, address, _class);
        for (int i = 0; i < people.length; i++) {
            if (people[i] == null) {
                people[i] = newStudent;
                break;
            } else {
                System.out.println("Đã có thông tin. Mời nhập ID khác.");
                break;
            }
        }
    }

    public static void creatNewTeacher (Person[] people) {
        System.out.println("Nhập id cho giáo viên mới: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập tên giáo viên mới: ");
        String name = scanner.nextLine();
        System.out.println("Nhập tuổi giáo viên mới: ");
        int age = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập địa chỉ giáo viên mới: ");
        String address = scanner.nextLine();
        System.out.println("Nhập trình độ giáo viên mới: ");
        String level = scanner.nextLine();
        Teacher newTeacher = new Teacher(id, name, age, address, level);
        for (int i = 0; i < people.length; i++) {
            if (people[i] == null) {
                people[i] = newTeacher;
                break;
            } else {
                System.out.println("Đã có thông tin. Mời nhập ID khác.");
                break;
            }
        }
    }

    public static void editStudent (Person[] people) {
        System.out.println("Nhập id sinh viên muốn sửa thông tin: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mục thông tin muốn chỉnh sửa: ");
        System.out.println("1. Sửa id");
        System.out.println("2. Sửa tên");
        System.out.println("3. Sửa tuổi");
        System.out.println("4. Sửa địa chỉ");
        System.out.println("5. Sửa lớp");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Nhập id mới: ");
                int newId = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < people.length; i++) {
                    if (people[i].getId() == id) {
                        people[i].setId(newId);
                        break;
                    } else if (newId == id) {
                        System.out.println("Id đã bị trùng");
                        people[i].setId(id);
                        break;
                    }
                }
                break;

            case 2:
                System.out.println("Nhập tên mới: ");
                String newName = scanner.nextLine();
                for (int i = 0; i < people.length; i++) {
                    if (id == people[i].getId()) {
                        people[i].setName(newName);
                        break;
                    }
                }
                break;

            case 3:
                System.out.println("Nhập tuổi mới: ");
                int newAge = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < people.length; i++) {
                    if (id == people[i].getId()) {
                        people[i].setAge(newAge);
                        break;
                    }
                }
                break;

            case 4:
                System.out.println("Nhập địa chỉ mới: ");
                String newAddress = scanner.nextLine();
                for (int i = 0; i < people.length; i++) {
                    if (id == people[i].getId()) {
                        people[i].setAddress(newAddress);
                        break;
                    }
                }
                break;

            case 5:
                System.out.println("Nhập lớp mới: ");
                String newClass = scanner.nextLine();
                for (int i = 0; i < people.length; i++) {
                    if (id == people[i].getId() && people[i] instanceof Student) {
//                        people[i] = new Student(people[i].id, people[i].name, people[i].age, people[i].address, newClass);
                        ((Student)people[i]).set_class(newClass);
                        break;
                    }
                }
                break;

            default:
                System.out.println("Mời nhập lại");
        }
    }

    public static void editTeacher (Person[] people) {
        System.out.println("Nhập id giáo viên muốn sửa thông tin: ");
        int id = Integer.parseInt(scanner.nextLine());
        System.out.println("Nhập mục thông tin muốn chỉnh sửa: ");
        System.out.println("1. Sửa id");
        System.out.println("2. Sửa tên");
        System.out.println("3. Sửa tuổi");
        System.out.println("4. Sửa địa chỉ");
        System.out.println("5. Sửa trình độ");
        int choice = Integer.parseInt(scanner.nextLine());
        switch (choice) {
            case 1:
                System.out.println("Nhập id mới: ");
                int newId = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < people.length; i++) {
                    if (people[i].getId() == id) {
                        people[i].setId(newId);
                        break;
                    } else if (newId == id) {
                        System.out.println("Id đã bị trùng");
                        people[i].setId(id);
                        break;
                    }
                }
                break;

            case 2:
                System.out.println("Nhập tên mới: ");
                String newName = scanner.nextLine();
                for (int i = 0; i < people.length; i++) {
                    if (id == people[i].getId()) {
                        people[i].setName(newName);
                        break;
                    }
                }
                break;

            case 3:
                System.out.println("Nhập tuổi mới: ");
                int newAge = Integer.parseInt(scanner.nextLine());
                for (int i = 0; i < people.length; i++) {
                    if (id == people[i].getId()) {
                        people[i].setAge(newAge);
                        break;
                    }
                }
                break;

            case 4:
                System.out.println("Nhập địa chỉ mới: ");
                String newAddress = scanner.nextLine();
                for (int i = 0; i < people.length; i++) {
                    if (id == people[i].getId()) {
                        people[i].setAddress(newAddress);
                        break;
                    }
                }
                break;

            case 5:
                System.out.println("Nhập trình độ mới: ");
                String newLevel = scanner.nextLine();
                for (int i = 0; i < people.length; i++) {
                    if (id == people[i].getId() && people[i] instanceof Teacher) {
//                        people[i] = new Teacher(people[i].id, people[i].name, people[i].age, people[i].address, newLevel);
                        ((Teacher)people[i]).setLevel(newLevel);
                        break;
                    }
                }
                break;

            default:
                System.out.println("Mời nhập lại");
        }
    }
}
