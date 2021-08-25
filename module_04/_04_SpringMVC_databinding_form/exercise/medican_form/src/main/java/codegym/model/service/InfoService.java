package codegym.model.service;

import codegym.model.bean.PersonalInformation;

import java.util.List;

public interface InfoService {
    PersonalInformation edit(PersonalInformation newPersonInfo);
    List<String> gender();
    List<String> nationality();
}
