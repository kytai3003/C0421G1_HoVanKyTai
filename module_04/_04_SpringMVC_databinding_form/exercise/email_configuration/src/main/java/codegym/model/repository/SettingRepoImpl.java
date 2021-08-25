package codegym.model.repository;

import codegym.model.bean.Setting;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class SettingRepoImpl implements ISettingRepo{


    @Override
    public Setting edit(Setting newSetting) {
        return newSetting;
    }

    @Override
    public List<String> languages() {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");

        return languages;
    }

    @Override
    public List<Integer> pageSize() {
        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);

        return pageSize;
    }
}
