package com.example.demo.dto;


import com.example.demo.model.entity.Account;
import com.example.demo.model.entity.FormTeacher;
import com.example.demo.model.entity.SchoolBus;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;
import java.util.Set;

public class StudentDto implements Validator {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer studentId;

    @NotBlank(message = "Không được để trống")
    @Size(min = 5, max = 50, message = "Tối thiểu 5 ký tự")
    private String studentName;

    @NotBlank(message = "Không được để trống")
    @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Định dạng dd/mm/yyyy")
    private String studentDob;


    private Account account;

    private FormTeacher teacher;
    private Set<SchoolBus> buses;

    public StudentDto() {
    }

    public StudentDto(Integer studentId, @NotBlank(message = "Không được để trống và tối thiểu 5 ký tự") @Size(min = 5, max = 50) String studentName, @NotBlank @Pattern(regexp = "\\d{2}/\\d{2}/\\d{4}", message = "Không được để trống, định dạng dd/mm/yyyy") String studentDob, Account account, FormTeacher teacher, Set<SchoolBus> buses) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        StudentDto studentDto = (StudentDto) target;
        if (!studentDto.getAccount().getAccountName().startsWith("C04")) {
            errors.rejectValue("studentName", "name.invalid1", "Tên phải bắt đầu bằng 'C04'");
        }
    }
}
