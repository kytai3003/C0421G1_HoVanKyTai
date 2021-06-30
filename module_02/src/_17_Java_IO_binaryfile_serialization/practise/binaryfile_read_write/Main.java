package _17_Java_IO_binaryfile_serialization.practise.binaryfile_read_write;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) throws IOException {
        List<Student> students = new ArrayList<>();
        students.add(new Student(1, "Nhật", "Hà Nội"));
        students.add(new Student(2, "Phục", "Hà Nội"));
        students.add(new Student(3, "Diệp", "Đà Nẵng"));
        students.add(new Student(4, "Minh", "Hà Nội"));
        students.add(new Student(5, "Hà", "Hà Nội"));
        writeToFile("D:\\C2401G1_HoVanKyTai\\module_02\\src\\_17_Java_IO_binaryfile_serialization\\practise\\binaryfile_read_write\\student.txt", students);
        List<Student> studentDataFromFile = readDataFromFile("D:\\C2401G1_HoVanKyTai\\module_02\\src\\_17_Java_IO_binaryfile_serialization\\practise\\binaryfile_read_write\\student.txt");
        for (Student student : studentDataFromFile){
            System.out.println(student);
        }
    }

    public static void writeToFile(String path, List<Student> students) throws IOException {
        FileOutputStream fileOutputStream = null;
        ObjectOutputStream objectOutputStream = null;
        try {
            fileOutputStream = new FileOutputStream(path);
            objectOutputStream = new ObjectOutputStream(fileOutputStream);
            objectOutputStream.writeObject(students);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            fileOutputStream.close();
            objectOutputStream.close();
        }
    }

    public static List<Student> readDataFromFile(String path) throws IOException {
        List<Student> students = new ArrayList<>();
        FileInputStream fileInputStream = null;
        ObjectInputStream objectInputStream = null;
        try{
            fileInputStream = new FileInputStream(path);
            objectInputStream = new ObjectInputStream(fileInputStream);
            students = (List<Student>) objectInputStream.readObject();

        }catch(Exception ex){
            ex.printStackTrace();
        } finally {
            fileInputStream.close();
            objectInputStream.close();
        }
        return students;
    }
}
