package codegym.model.repository;

import codegym.model.bean.PersonalInformation;

import java.util.List;

public interface InfoRepo {

    PersonalInformation edit(PersonalInformation newPersonInfo);
    List<String> gender();
    List<String> nationality();
}
