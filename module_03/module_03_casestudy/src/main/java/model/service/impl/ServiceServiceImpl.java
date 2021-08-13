package model.service.impl;

import model.bean.Service;
import model.repository.IServiceRepository;
import model.repository.impl.ServiceRepositoryImpl;
import model.service.IServiceService;

import java.sql.SQLException;
import java.util.List;

public class ServiceServiceImpl implements IServiceService {

    IServiceRepository iServiceRepository = new ServiceRepositoryImpl();
    @Override
    public void addNewService(Service service) throws SQLException {
        this.iServiceRepository.addNewService(service);
    }

    @Override
    public Service selectService(int id) {
        return this.iServiceRepository.selectService(id);
    }

    @Override
    public List<Service> selectAllService() {
        return this.iServiceRepository.selectAllService();
    }

    @Override
    public boolean deleteService(int id) throws SQLException {
        return this.iServiceRepository.deleteService(id);
    }

    @Override
    public boolean updateService(Service service) throws SQLException {
        return this.iServiceRepository.updateService(service);
    }

    @Override
    public List<Service> searchByName(String name) {
        return this.iServiceRepository.searchByName(name);
    }
}
