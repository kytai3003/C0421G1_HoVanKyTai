package model.repository;

import model.bean.User;

import java.sql.SQLException;
import java.util.List;

public interface IUserRepository {
    void insertUser(User user) throws SQLException;

    User selectUser(int id);

    List<User> selectAllUsers();

    boolean deleteUser(int id) throws SQLException;

    boolean updateUser(User user) throws SQLException;

    List<User> searchByCountry(String country);

    List<User> nameSort();

    User getUserById(int id);

    void insertUserStore(User user) throws SQLException;

    void addUserTransaction(User user, int[] permision);

    public void insertUpdateWithoutTransaction();

    public void insertUpdateUseTransaction();

    // ****Bài tập 1****
    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng hiển thị danh sách users
    List<User> selectAllUseCallable();

    // ****Bài tập 1****
    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng sửa thông tin user
    boolean updateUserUseCallable(User user) throws SQLException;

    // ****Bài tập 1****
    //Gọi Stored Procedures từ JDBC sử dụng CallableStatement cho chức năng xoá user
    boolean deleteUserUseCallable(int id) throws SQLException;
}
