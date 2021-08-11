package model.repository.impl;

import model.bean.EmployeePosition;
import model.repository.IEmployeePosRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class EmployeePosRepoImpl implements IEmployeePosRepo {
    private final String SELECT_ALL_POSITION = "select * from position";

    BaseRepository baseRepository = new BaseRepository();
    @Override
    public List<EmployeePosition> selectAllPosition() {
        List<EmployeePosition> employeePositions = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_POSITION);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("position_id");
                String name = resultSet.getString("position_name");
                employeePositions.add(new EmployeePosition(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return employeePositions;
    }
    }
