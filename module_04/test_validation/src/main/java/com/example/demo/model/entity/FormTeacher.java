package com.example.demo.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class FormTeacher {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer teacherId;

    private String teacherName;

    @OneToMany(mappedBy = "teacher")
    private Set<Student> students;

    public FormTeacher() {
    }

    public FormTeacher(Integer teacherId, String teacherName, Set<Student> students) {
        this.teacherId = teacherId;
        this.teacherName = teacherName;
        this.students = students;
    }

    public Integer getTeacherId() {
        return teacherId;
    }

    public void setTeacherId(Integer teacherId) {
        this.teacherId = teacherId;
    }

    public String getTeacherName() {
        return teacherName;
    }

    public void setTeacherName(String teacherName) {
        this.teacherName = teacherName;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }
}
