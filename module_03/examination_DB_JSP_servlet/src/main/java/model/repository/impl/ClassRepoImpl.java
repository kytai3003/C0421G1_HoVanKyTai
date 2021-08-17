package model.repository.impl;

import model.bean.Class;
import model.bean.Student;
import model.repository.IClassRepo;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ClassRepoImpl implements IClassRepo {
    private static final String SELECT_ALL_CLASS = "select * from class";

    BaseRepository baseRepository = new BaseRepository();

    private void printSQLException(SQLException ex) {
        for (Throwable e : ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    @Override
    public List<Class> selectAll() throws SQLException {
        List<Class> classList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_CLASS);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt("id_class");
                String name = resultSet.getString("name_class");
                classList.add(new Class(id, name));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return classList;
    }
}
