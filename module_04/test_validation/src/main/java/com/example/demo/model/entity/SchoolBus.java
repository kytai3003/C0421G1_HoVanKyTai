package com.example.demo.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class SchoolBus {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer busId;

    private String busDriver;

    @ManyToMany(mappedBy = "buses")
    private Set<Student> students;

    public SchoolBus() {
    }

    public SchoolBus(String busDriver, Set<Student> students) {
        this.busDriver = busDriver;
        this.students = students;
    }

    public Integer getBusId() {
        return busId;
    }

    public void setBusId(Integer busId) {
        this.busId = busId;
    }

    public String getBusDriver() {
        return busDriver;
    }

    public void setBusDriver(String busDriver) {
        this.busDriver = busDriver;
    }

    public Set<Student> getStudents() {
        return students;
    }

    public void setStudents(Set<Student> students) {
        this.students = students;
    }

}
