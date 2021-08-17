package model.service.impl;

import model.bean.Class;
import model.repository.IClassRepo;
import model.repository.impl.ClassRepoImpl;
import model.service.IClassService;

import java.sql.SQLException;
import java.util.List;

public class ClassServiceImpl implements IClassService {

    IClassRepo iClassRepo = new ClassRepoImpl();
    @Override
    public List<Class> selectAll() throws SQLException {
        return this.iClassRepo.selectAll();
    }
}
