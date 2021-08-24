package model.service;

import model.bean.Login;
import model.bean.User;
import model.repository.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService{

    @Autowired
    UserRepo userRepo;

    @Override
    public User checkLogin(Login login) {
        return this.userRepo.checkLogin(login);
    }
}
