package model.service.impl;

import model.bean.EmployeeEducation;
import model.repository.IEmployeeEduRepo;
import model.repository.impl.EmployeeEduRepoImpl;
import model.service.IEmployeeEduService;

import java.util.List;

public class EmployeeEduSerImpl implements IEmployeeEduService {

    IEmployeeEduRepo iEmployeeEduRepo = new EmployeeEduRepoImpl();

    @Override
    public List<EmployeeEducation> selectAllEducation() {
        return this.iEmployeeEduRepo.selectAllEducation();
    }
}
