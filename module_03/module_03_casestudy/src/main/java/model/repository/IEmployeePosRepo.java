package model.repository;

import model.bean.EmployeePosition;

import java.util.List;

public interface IEmployeePosRepo {
    List<EmployeePosition> selectAllPosition();
}
