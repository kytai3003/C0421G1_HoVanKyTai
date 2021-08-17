package model.bean;

import java.sql.Date;

public class Student {
    private int studentId;
    private String studentName;
    private String address;
    private Date dayOfBirth;
    private int year;
    private int classId;


    public Student(int studentId, String studentName, String address, Date dayOfBirth, int year, int classId) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.address = address;
        this.dayOfBirth = dayOfBirth;
        this.year = year;
        this.classId = classId;
    }

    public Student(String studentName, String address, Date dayOfBirth, int year, int classId) {
        this.studentName = studentName;
        this.address = address;
        this.dayOfBirth = dayOfBirth;
        this.year = year;
        this.classId = classId;
    }

    public Student() {
    }

    public int getStudentId() {
        return studentId;
    }

    public void setStudentId(int studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Date getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(Date dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getClassId() {
        return classId;
    }

    public void setClassId(int classId) {
        this.classId = classId;
    }
}
