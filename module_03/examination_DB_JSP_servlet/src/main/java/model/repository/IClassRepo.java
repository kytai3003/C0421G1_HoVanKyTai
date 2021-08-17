package model.repository;

import model.bean.Class;
import java.sql.SQLException;
import java.util.List;

public interface IClassRepo {
    List<Class> selectAll() throws SQLException;
}
