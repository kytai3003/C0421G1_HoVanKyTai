package model.service.impl;

import model.bean.CustomerType;
import model.repository.ICustomerTypeRepository;
import model.repository.impl.CustomerTypeRepoImpl;
import model.service.ICustomerTypeService;

import java.util.List;

public class CustomerTypeSerImpl implements ICustomerTypeService {

    ICustomerTypeRepository iCustomerTypeRepository = new CustomerTypeRepoImpl();
    @Override
    public List<CustomerType> selectAllType() {
        return this.iCustomerTypeRepository.selectAllType();
    }
}
