package model.service.impl;

import model.bean.Student;
import model.repository.IStudentRepo;
import model.repository.impl.StudentRepoImpl;
import model.service.IStudentService;
import model.service.common.Validate;

import java.sql.SQLException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class StudentServiceImpl implements IStudentService {

    IStudentRepo iStudentRepo = new StudentRepoImpl();
    @Override
    public List<Student> selectAll() throws SQLException {
        return this.iStudentRepo.selectAll();
    }

    @Override
    public Map<String, String> addNew(Student student) throws SQLException {
        Map<String, String> mapMess = new HashMap<>();
        if (Validate.validateNumber(student.getYear()) != null) {
            mapMess.put("code", Validate.validateNumber(student.getYear()));
        } else {
            this.iStudentRepo.editStudent(student);
        }
        return mapMess;
    }

    @Override
    public boolean editStudent(Student student) throws SQLException {
        return false;
    }
}
