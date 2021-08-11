package model.service;

import model.bean.EmployeeEducation;

import java.util.List;

public interface IEmployeeEduService {
    List<EmployeeEducation> selectAllEducation();
}
