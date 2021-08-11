package model.repository;

import model.bean.EmployeeDivision;

import java.util.List;

public interface IEmployeeDivRepo {
    List<EmployeeDivision> selectAllDivision();
}
