package model.repository;

import model.bean.EmployeeEducation;

import java.util.List;

public interface IEmployeeEduRepo {
    List<EmployeeEducation> selectAllEducation();
}
