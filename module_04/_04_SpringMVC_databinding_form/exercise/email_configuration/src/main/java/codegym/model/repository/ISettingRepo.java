package codegym.model.repository;

import codegym.model.bean.Setting;

import java.util.List;

public interface ISettingRepo {
    Setting edit(Setting newSetting);
    List<String> languages();
    List<Integer> pageSize();
}
