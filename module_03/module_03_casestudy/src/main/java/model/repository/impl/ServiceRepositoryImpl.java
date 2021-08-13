package model.repository.impl;
import model.bean.Employee;
import model.bean.Service;
import model.repository.IServiceRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServiceRepositoryImpl implements IServiceRepository {
    private static final String INSERT_SERVICE_SQL = "INSERT INTO service" + "  (service_name, service_code, service_area, service_cost, service_max_people, standard_room, description_other_convenience, pool_area, number_of_floors, rent_type_id, service_type_id) VALUES " +
            " (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?);";
    private static final String SELECT_SERVICE_BY_ID = "select * from service where service_id =?";
    private static final String SELECT_ALL_SERVICE = "select * from service";
    private static final String DELETE_SERVICE_SQL = "delete from service where service_id = ?";
    private static final String UPDATE_SERVICE_SQL = "update service set service_name = ?,service_code = ?, service_area = ?, service_cost = ?, service_max_people = ?, standard_room = ?, description_other_convenience = ?, pool_area = ?, number_of_floors = ?, rent_type_id = ?, service_type_id = ? where service_id = ?;";
    private static final String SELECT_SERVICE_BY_NAME = "select * from service where service_name like concat('%', ? , '%');";


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
    public void addNewService(Service service) throws SQLException {
        System.out.println(INSERT_SERVICE_SQL);
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(INSERT_SERVICE_SQL);
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setString(2, service.getServiceCode());
            preparedStatement.setInt(3, service.getServiceArea());
            preparedStatement.setDouble(4, service.getServiceCost());
            preparedStatement.setInt(5, service.getServiceMaxPeople());
            preparedStatement.setString(6, service.getStandardRoom());
            preparedStatement.setString(7, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(8, service.getPoolArea());
            preparedStatement.setInt(9, service.getNumberOfFloor());
            preparedStatement.setInt(10, service.getRentTypeId());
            preparedStatement.setInt(11, service.getServiceTypeId());
            System.out.println(preparedStatement);
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    @Override
    public Service selectService(int id) {
        Service service = null;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_SERVICE_BY_ID);
            preparedStatement.setInt(1, id);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String name = resultSet.getString("service_name");
                String code = resultSet.getString("service_code");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getDouble("service_cost");
                int max = resultSet.getInt("service_max_people");
                String standard = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double pool = resultSet.getDouble("pool_area");
                int floor = resultSet.getInt("number_of_floors");
                int rentType = resultSet.getInt("rent_type_id");
                int serviceType = resultSet.getInt("service_type_id");
                service = new Service(id, code, name, area, cost, max, rentType, serviceType, standard, description, pool, floor);
            }
        } catch (SQLException e) {
            printSQLException(e);
        }
        return service;
    }

    @Override
    public List<Service> selectAllService() {
        List<Service> serviceList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_SERVICE);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String name = resultSet.getString("service_name");
                String code = resultSet.getString("service_code");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getDouble("service_cost");
                int max = resultSet.getInt("service_max_people");
                String standard = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double pool = resultSet.getDouble("pool_area");
                int floor = resultSet.getInt("number_of_floors");
                int rentType = resultSet.getInt("rent_type_id");
                int serviceType = resultSet.getInt("service_type_id");
                serviceList.add(new Service(id, code, name, area, cost, max, rentType, serviceType, standard, description, pool, floor));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return serviceList;
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        boolean rowDeleted = false;
        try {
            PreparedStatement statement = baseRepository.getConnection().prepareStatement(DELETE_SERVICE_SQL);
            statement.setInt(1, id);
            rowDeleted = statement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowDeleted;
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        boolean rowUpdated = false;
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(UPDATE_SERVICE_SQL);
            System.out.println(preparedStatement);
            preparedStatement.setString(1, service.getServiceName());
            preparedStatement.setString(2, service.getServiceCode());
            preparedStatement.setInt(3, service.getServiceArea());
            preparedStatement.setDouble(4, service.getServiceCost());
            preparedStatement.setInt(5, service.getServiceMaxPeople());
            preparedStatement.setString(6, service.getStandardRoom());
            preparedStatement.setString(7, service.getDescriptionOtherConvenience());
            preparedStatement.setDouble(8, service.getPoolArea());
            preparedStatement.setInt(9, service.getNumberOfFloor());
            preparedStatement.setInt(10, service.getRentTypeId());
            preparedStatement.setInt(11, service.getServiceTypeId());
            preparedStatement.setInt(12, service.getServiceId());
            System.out.println(preparedStatement);

            rowUpdated = preparedStatement.executeUpdate() > 0;
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return rowUpdated;
    }

    @Override
    public List<Service> searchByName(String name) {
        List<Service> services = new ArrayList<>();
        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_SERVICE_BY_NAME);
            preparedStatement.setString(1, name);

            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("service_id");
                String nameSearch = resultSet.getString("service_name");
                String code = resultSet.getString("service_code");
                int area = resultSet.getInt("service_area");
                double cost = resultSet.getDouble("service_cost");
                int max = resultSet.getInt("service_max_people");
                String standard = resultSet.getString("standard_room");
                String description = resultSet.getString("description_other_convenience");
                double pool = resultSet.getDouble("pool_area");
                int floor = resultSet.getInt("number_of_floors");
                int rentType = resultSet.getInt("rent_type_id");
                int serviceType = resultSet.getInt("service_type_id");
                services.add(new Service(id, code, nameSearch, area, cost, max, rentType, serviceType, standard, description, pool, floor));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return services;
    }
}
