package codegym.model.service;

import codegym.model.bean.Setting;

import java.util.List;

public interface ISettingService {
    Setting edit(Setting newSetting);
    List<String> languages();
    List<Integer> pageSize();
}
