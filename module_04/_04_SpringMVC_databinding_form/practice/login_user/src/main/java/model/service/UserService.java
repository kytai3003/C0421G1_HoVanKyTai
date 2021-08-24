package model.service;

import model.bean.Login;
import model.bean.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {
    User checkLogin(Login login);
}
