package model.repository;

import model.bean.Service;

import java.sql.SQLException;
import java.util.List;

public interface IServiceRepository {
    void addNewService(Service service) throws SQLException;

    Service selectService(int id);

    List<Service> selectAllService();

    boolean deleteService(int id) throws SQLException;

    boolean updateService(Service service) throws SQLException;

    List<Service> searchByName(String name);
}
