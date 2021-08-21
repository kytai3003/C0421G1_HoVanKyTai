package model.service.impl;

import model.bean.Catelogy;
import model.repository.ICatelogyRepo;
import model.repository.impl.CatelogyRepoImpl;
import model.service.ICateService;

import java.util.List;

public class CateServiceImpl implements ICateService {
    ICatelogyRepo iCatelogyRepo = new CatelogyRepoImpl();
    @Override
    public List<Catelogy> selectAll() {
        return this.iCatelogyRepo.selectAll();
    }
}
