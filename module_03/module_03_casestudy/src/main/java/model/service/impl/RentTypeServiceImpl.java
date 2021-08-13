package model.service.impl;

import model.bean.RentType;
import model.repository.IRentTypeRepo;
import model.repository.impl.RentTypeRepoImpl;
import model.service.IRentTypeService;

import java.util.List;

public class RentTypeServiceImpl implements IRentTypeService {

    IRentTypeRepo iRentTypeRepo = new RentTypeRepoImpl();

    @Override
    public List<RentType> selectAllType() {
        return this.iRentTypeRepo.selectAllType();
    }
}
