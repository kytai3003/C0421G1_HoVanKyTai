package model.service;

import model.repository.DictionaryRepo;
import model.repository.DictionaryRepoImpl;

import java.util.Map;

public class DictionaryServiceImpl implements DictionaryService{

    DictionaryRepo dictionaryRepo = new DictionaryRepoImpl();

    @Override
    public Map<String, String> searchWord() {
        return this.dictionaryRepo.searchWord();
    }
}
