package model.service.impl;

import model.bean.User;
import model.repository.IUserRepository;
import model.repository.impl.UserRepositoryImpl;
import model.service.IUserService;

import java.sql.SQLException;
import java.util.List;

public class UserServiceImpl implements IUserService {

    IUserRepository iUserRepository = new UserRepositoryImpl();

    @Override
    public void insertUser(User user) throws SQLException {
        this.iUserRepository.insertUser(user);
    }

    @Override
    public User selectUser(int id) {
        return this.iUserRepository.selectUser(id);
    }

    @Override
    public List<User> selectAllUsers() {
        return iUserRepository.selectAllUsers();
    }

    @Override
    public boolean deleteUser(int id) throws SQLException {
        return this.iUserRepository.deleteUser(id);
    }

    @Override
    public boolean updateUser(User user) throws SQLException {
        return this.iUserRepository.updateUser(user);
    }

    @Override
    public List<User> searchByCountry(String country) {
        return this.iUserRepository.searchByCountry(country);
    }

    @Override
    public List<User> nameSort() {
        return this.iUserRepository.nameSort();
    }


}
