package model.repository.impl;

import model.bean.AttachService;
import model.repository.IAttachServiceRepo;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AttachServiceRepoImpl implements IAttachServiceRepo {
    private final String SELECT_ALL_SERVICE = "select * from attach_service";


    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<AttachService> selectAllService() {
        List<AttachService> attachServices = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_SERVICE);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("attach_service_id");
                String name = resultSet.getString("attach_service_name");
                double cost = resultSet.getDouble("attach_service_cost");
                int unit = resultSet.getInt("attach_service_unit");
                String status = resultSet.getString("attach_service_status");
                attachServices.add(new AttachService(id, name, cost, unit, status));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return attachServices;
    }
}
