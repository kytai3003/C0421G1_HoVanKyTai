package model.repository;
import model.bean.User;

import java.util.List;

public interface IUserRepository {
    List<User> selectAllUser();
}
