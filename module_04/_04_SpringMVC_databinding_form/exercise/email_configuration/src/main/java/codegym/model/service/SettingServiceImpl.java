package codegym.model.service;

import codegym.model.bean.Setting;
import codegym.model.repository.ISettingRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SettingServiceImpl implements ISettingService{

    @Autowired
    ISettingRepo settingRepo;

    @Override
    public Setting edit(Setting newSetting) {
        return this.settingRepo.edit(newSetting);
    }

    @Override
    public List<String> languages() {
        return this.settingRepo.languages();
    }

    @Override
    public List<Integer> pageSize() {
        return this.settingRepo.pageSize();
    }
}
