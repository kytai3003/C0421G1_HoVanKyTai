package com.example.demo.model.service;

import com.example.demo.model.entity.SongInfo;
import com.example.demo.model.repository.ISongInfoRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class SongInfoServiceImpl implements ISongInfoService{

    @Autowired
    private ISongInfoRepo iSongInfoRepo;

    @Override
    public List<SongInfo> findAll() {
        return this.iSongInfoRepo.findAll();
    }

    @Override
    public SongInfo findById(int id) {
        return this.iSongInfoRepo.findById(id).get();
    }

    @Override
    public void save(SongInfo songInfo) {
        this.iSongInfoRepo.save(songInfo);
    }
}
