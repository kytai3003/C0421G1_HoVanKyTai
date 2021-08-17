package model.service;

import model.bean.Student;

import java.sql.SQLException;
import java.util.List;
import java.util.Map;

public interface IStudentService {
    List<Student> selectAll() throws SQLException;

    Map<String, String> addNew(Student student) throws SQLException;

    boolean editStudent(Student student) throws  SQLException;
}
