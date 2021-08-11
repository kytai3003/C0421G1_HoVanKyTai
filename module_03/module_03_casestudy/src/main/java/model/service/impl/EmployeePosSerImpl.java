package model.service.impl;

import model.bean.EmployeePosition;
import model.repository.IEmployeePosRepo;
import model.repository.impl.EmployeePosRepoImpl;
import model.service.IEmployeePosService;

import java.util.List;

public class EmployeePosSerImpl implements IEmployeePosService {

    IEmployeePosRepo iEmployeePosRepo = new EmployeePosRepoImpl();
    @Override
    public List<EmployeePosition> selectAllPosition() {
        return this.iEmployeePosRepo.selectAllPosition();
    }
}
