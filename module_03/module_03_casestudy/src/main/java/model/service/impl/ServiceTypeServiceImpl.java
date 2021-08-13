package model.service.impl;

import model.bean.ServiceType;
import model.repository.IServiceTypeRepo;
import model.repository.impl.ServiceTypeRepoImpl;
import model.service.IServiceTypeService;

import java.util.List;

public class ServiceTypeServiceImpl implements IServiceTypeService {

    IServiceTypeRepo iServiceTypeRepo = new ServiceTypeRepoImpl();

    @Override
    public List<ServiceType> selectAllType() {
        return this.iServiceTypeRepo.selectAllType();
    }
}
