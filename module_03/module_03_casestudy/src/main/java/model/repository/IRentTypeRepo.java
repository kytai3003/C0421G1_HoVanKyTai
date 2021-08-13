package model.repository;
import model.bean.RentType;

import java.util.List;

public interface IRentTypeRepo {
    List<RentType> selectAllType();
}
