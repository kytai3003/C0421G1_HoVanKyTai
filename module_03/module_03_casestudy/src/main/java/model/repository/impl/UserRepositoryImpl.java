package model.repository.impl;

import model.bean.EmployeeEducation;
import model.bean.User;
import model.repository.IUserRepository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements IUserRepository {
    private final String SELECT_ALL_USER = "select * from `user`";
    BaseRepository baseRepository = new BaseRepository();

    @Override
    public List<User> selectAllUser() {
        List<User> userList = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = baseRepository.getConnection().prepareStatement(SELECT_ALL_USER);
            System.out.println(preparedStatement);
            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                String username = resultSet.getString("username");
                String pw = resultSet.getString("password");
                userList.add(new User(username, pw));
            }
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return userList;
    }
}
