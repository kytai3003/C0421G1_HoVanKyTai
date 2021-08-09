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

    @Override
    public User getUserById(int id) {
        return this.iUserRepository.getUserById(id);
    }

    @Override
    public void insertUserStore(User user) throws SQLException {
        this.iUserRepository.insertUserStore(user);
    }

    @Override
    public void addUserTransaction(User user, int[] permision) {
        this.iUserRepository.addUserTransaction(user, permision);
    }

    @Override
    public void insertUpdateWithoutTransaction() {
        this.iUserRepository.insertUpdateWithoutTransaction();
    }

    @Override
    public void insertUpdateUseTransaction() {
        this.iUserRepository.insertUpdateWithoutTransaction();
    }

    // ****Bài tập 1****
    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng hiển thị danh sách users
    @Override
    public List<User> selectAllUseCallable() {
        return this.iUserRepository.selectAllUseCallable();
    }

    // ****Bài tập 1****
    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
    @Override
    public boolean updateUserUseCallable(User user) throws SQLException {
        return this.iUserRepository.updateUserUseCallable(user);
    }

    // ****Bài tập 1****
    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user
    @Override
    public boolean deleteUserUseCallable(int id) throws SQLException {
        return this.iUserRepository.deleteUserUseCallable(id);
    }
}
