package model.repository;
import model.bean.ServiceType;

import java.util.List;

public interface IServiceTypeRepo {
    List<ServiceType> selectAllType();
}
