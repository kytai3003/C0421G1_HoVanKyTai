package model.repository;

import model.bean.Student;

import java.sql.SQLException;
import java.util.List;

public interface IStudentRepo {
    List<Student> selectAll() throws SQLException;

    void addNew(Student student) throws SQLException;

    boolean editStudent(Student student) throws  SQLException;
}
