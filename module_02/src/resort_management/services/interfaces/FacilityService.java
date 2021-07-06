package resort_management.services.interfaces;

import java.util.Map;

public interface FacilityService<T> extends Service {
    void displayListMaintenance();
    Map<T,Integer> getList();
}
