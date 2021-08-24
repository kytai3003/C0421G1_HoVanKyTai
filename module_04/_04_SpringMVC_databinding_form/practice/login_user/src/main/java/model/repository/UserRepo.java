package model.repository;

import model.bean.Login;
import model.bean.User;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepo {
     User checkLogin(Login login);
}
