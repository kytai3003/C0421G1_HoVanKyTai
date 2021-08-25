package codegym.model.repository;

import codegym.model.bean.PersonalInformation;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class InfoRepoImpl implements InfoRepo{


    @Override
    public PersonalInformation edit(PersonalInformation newPersonInfo) {
        return newPersonInfo;
    }

    @Override
    public List<String> gender() {
        List<String> genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        genderList.add("Other");

        return genderList;
    }

    @Override
    public List<String> nationality() {
        List<String> nationList = new ArrayList<>();
        nationList.add("Vietnamese");
        nationList.add("Chinese");
        nationList.add("Cambodia");

        return nationList;
    }
}
