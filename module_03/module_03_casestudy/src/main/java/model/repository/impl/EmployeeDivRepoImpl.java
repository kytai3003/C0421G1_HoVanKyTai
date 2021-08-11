package model.repository.impl;

import model.bean.EmployeeDivision;
import model.repository.IEmployeeDivRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDivRepoImpl implements IEmployeeDivRepo {
    private final String SELECT_ALL_DIVISION = "select * from division";

    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<EmployeeDivision> selectAllDivision() {
        List<EmployeeDivision> employeeDivisions = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_DIVISION);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("division_id");
                String name = resultSet.getString("division_name");
                employeeDivisions.add(new EmployeeDivision(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeeDivisions;
    }
    }
