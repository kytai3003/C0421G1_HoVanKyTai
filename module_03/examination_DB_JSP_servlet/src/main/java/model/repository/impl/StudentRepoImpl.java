package model.repository.impl;

import model.bean.Student;
import model.repository.IStudentRepo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class StudentRepoImpl implements IStudentRepo {
    private static final String SELECT_ALL_STUDENT = "select * from student";
    private static final String INSERT_NEW_STUDENT = "insert into student (name_student, address, year, day_of_birth, id_class)" +
            "values (?, ?, ?, ?, ?)";

    BaseRepository baseRepository = new BaseRepository();

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<Student> selectAll() throws SQLException {
        List<Student> studentList = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_STUDENT);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_student");
                String name = resultSet.getString("name_student");
                String address = resultSet.getString("address");
                Date dob = resultSet.getDate("day_of_birth");
                int year = resultSet.getInt("year");
                int classID = resultSet.getInt("id_class");
                studentList.add(new Student(id, name, address, dob,year, classID));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return studentList;
    }

    @Override
    public void addNew(Student student) throws SQLException {
        System.out.println(INSERT_NEW_STUDENT);
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_NEW_STUDENT);
            preparedStatement.setString(1, student.getStudentName());
            preparedStatement.setString(2, student.getAddress());
            preparedStatement.setInt(3, student.getYear());
            preparedStatement.setDate(4, student.getDayOfBirth());
            preparedStatement.setInt(5, student.getClassId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public boolean editStudent(Student student) throws SQLException {
        return false;
    }
}
