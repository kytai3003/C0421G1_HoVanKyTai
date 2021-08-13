package model.repository.impl;

import model.bean.RentType;
import model.bean.ServiceType;
import model.repository.IServiceTypeRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceTypeRepoImpl implements IServiceTypeRepo {
    private final String SELECT_ALL_TYPE = "select * from service_type";

    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<ServiceType> selectAllType() {
        List<ServiceType> serviceTypes = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_TYPE);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("service_type_id");
                String name = resultSet.getString("service_type_name");
                serviceTypes.add(new ServiceType(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceTypes;
    }
}
