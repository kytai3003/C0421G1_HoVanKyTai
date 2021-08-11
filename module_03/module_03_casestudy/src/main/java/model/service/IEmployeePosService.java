package model.service;

import model.bean.EmployeePosition;

import java.util.List;

public interface IEmployeePosService {
    List<EmployeePosition> selectAllPosition();
}
