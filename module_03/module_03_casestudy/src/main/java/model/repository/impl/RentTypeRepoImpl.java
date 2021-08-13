package model.repository.impl;

import model.bean.EmployeePosition;
import model.bean.RentType;
import model.repository.IRentTypeRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RentTypeRepoImpl implements IRentTypeRepo {
    private final String SELECT_ALL_TYPE = "select * from rent_type";

    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<RentType> selectAllType() {
        List<RentType> rentTypes = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_TYPE);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("rent_type_id");
                String name = resultSet.getString("rent_type_name");
                rentTypes.add(new RentType(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rentTypes;
    }
}
