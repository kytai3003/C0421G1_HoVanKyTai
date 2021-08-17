package model.repository;

import model.bean.AttachService;
import java.util.List;

public interface IAttachServiceRepo {
    List<AttachService> selectAllService();
}
