package model.service;

import model.bean.Class;

import java.sql.SQLException;
import java.util.List;

public interface IClassService {
    List<Class> selectAll() throws SQLException;

}
