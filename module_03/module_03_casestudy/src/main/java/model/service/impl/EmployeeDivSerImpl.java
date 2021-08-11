package model.service.impl;

import model.bean.EmployeeDivision;
import model.repository.IEmployeeDivRepo;
import model.repository.impl.EmployeeDivRepoImpl;
import model.service.IEmployeeDivService;

import java.util.List;

public class EmployeeDivSerImpl implements IEmployeeDivService {

    IEmployeeDivRepo iEmployeeDivRepo = new EmployeeDivRepoImpl();
    @Override
    public List<EmployeeDivision> selectAllDivision() {
        return this.iEmployeeDivRepo.selectAllDivision();
    }
}
