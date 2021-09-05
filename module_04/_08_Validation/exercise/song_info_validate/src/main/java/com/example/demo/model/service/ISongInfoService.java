package com.example.demo.model.service;

import com.example.demo.model.entity.SongInfo;
import java.util.List;
import java.util.Optional;

public interface ISongInfoService {
    List<SongInfo> findAll();

    SongInfo findById(int id);

    void save(SongInfo songInfo);
}
