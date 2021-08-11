package model.repository.impl;

import model.bean.EmployeeEducation;
import model.bean.EmployeePosition;
import model.repository.IEmployeeEduRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeEduRepoImpl implements IEmployeeEduRepo {
    private final String SELECT_ALL_EDUCATION = "select * from education_degree";

    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<EmployeeEducation> selectAllEducation() {
        List<EmployeeEducation> employeeEducations = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_EDUCATION);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("education_degree_id");
                String name = resultSet.getString("education_degree_name");
                employeeEducations.add(new EmployeeEducation(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeEducations;
    }
    }
