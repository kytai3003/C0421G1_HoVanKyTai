package codegym.model.service;

import codegym.model.bean.PersonalInformation;
import codegym.model.repository.InfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class InfoServiceImpl implements InfoService{

    @Autowired
    InfoRepo infoRepo;

    @Override
    public PersonalInformation edit(PersonalInformation newPersonInfo) {
        return this.infoRepo.edit(newPersonInfo);
    }

    @Override
    public List<String> gender() {
        return this.infoRepo.gender();
    }

    @Override
    public List<String> nationality() {
        return this.infoRepo.nationality();
    }
}
