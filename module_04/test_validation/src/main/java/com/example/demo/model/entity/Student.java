package com.example.demo.model.entity;
import javax.persistence.*;
import java.util.Set;

@Entity
public class Student {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;
    private String studentName;
    private String studentDob;

    @Override
    public String toString() {
        return "Student{" +
                "studentId=" + studentId +
                ", studentName='" + studentName + '\'' +
                ", studentDob='" + studentDob + '\'' +
                ", account=" + account +
                ", teacher=" + teacher +
                ", buses=" + buses +
                '}';
    }

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "account_id", referencedColumnName = "accountId")
    private Account account;

    @ManyToOne(targetEntity = FormTeacher.class)
    @JoinColumn(name = "teacher_id", referencedColumnName = "teacherId")
    private FormTeacher teacher;

    @ManyToMany(targetEntity = SchoolBus.class)
    @JoinTable(name = "student_bus", joinColumns = @JoinColumn(name = "student_id"), inverseJoinColumns = @JoinColumn(name = "bus_id"))
    private Set<SchoolBus> buses;


//    ([\\p{Lu}][\\p{Ll}]{1,8})(\\s([\\p{Lu}]|[\\p{Lu}][\\p{Ll}]{1,10})){0,5}$
    public Student() {
    }

    public Student(Integer studentId, String studentName, String studentDob, Account account, FormTeacher teacher, Set<SchoolBus> buses) {
        this.studentId = studentId;
        this.studentName = studentName;
        this.studentDob = studentDob;
        this.account = account;
        this.teacher = teacher;
        this.buses = buses;
    }

    public Integer getStudentId() {
        return studentId;
    }

    public void setStudentId(Integer studentId) {
        this.studentId = studentId;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public String getStudentDob() {
        return studentDob;
    }

    public void setStudentDob(String studentDob) {
        this.studentDob = studentDob;
    }

    public Account getAccount() {
        return account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

    public FormTeacher getTeacher() {
        return teacher;
    }

    public void setTeacher(FormTeacher teacher) {
        this.teacher = teacher;
    }

    public Set<SchoolBus> getBuses() {
        return buses;
    }

    public void setBuses(Set<SchoolBus> buses) {
        this.buses = buses;
    }
}
