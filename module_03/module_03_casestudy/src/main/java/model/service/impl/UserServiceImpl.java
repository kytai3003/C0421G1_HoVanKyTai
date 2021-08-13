package model.service.impl;

import model.bean.User;
import model.repository.IUserRepository;
import model.repository.impl.UserRepositoryImpl;
import model.service.IUserService;

import java.util.List;

public class UserServiceImpl implements IUserService {

    IUserRepository iUserRepository = new UserRepositoryImpl();
    @Override
    public List<User> selectAllUser() {
        return this.iUserRepository.selectAllUser();
    }
}
