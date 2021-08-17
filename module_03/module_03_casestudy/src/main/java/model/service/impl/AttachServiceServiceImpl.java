package model.service.impl;

import model.bean.AttachService;
import model.repository.IAttachServiceRepo;
import model.repository.impl.AttachServiceRepoImpl;
import model.service.IAttachServiceService;

import java.util.List;

public class AttachServiceServiceImpl implements IAttachServiceService {

    IAttachServiceRepo iAttachServiceRepo = new AttachServiceRepoImpl();
    @Override
    public List<AttachService> selectAllService() {
        return this.iAttachServiceRepo.selectAllService();
    }
}
