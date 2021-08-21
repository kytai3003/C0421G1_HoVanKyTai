package model.repository;

import java.util.HashMap;
import java.util.Map;

public class DictionaryRepoImpl implements DictionaryRepo{

    @Override
    public Map<String, String> searchWord() {
        Map<String, String> map = new HashMap<>();
        map.put("cat", "Con mèo");
        map.put("dog", "Con chó");
        map.put("pig", "Con heo");
        map.put("pen", "Cây bút");
        map.put("ruler", "Cây thước");
        map.put("table", "Cái bàn");
        map.put("blackboard", "Cái bảng");

        return map;
    }
}
