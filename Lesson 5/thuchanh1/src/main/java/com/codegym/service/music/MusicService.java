package com.codegym.service.music;

import com.codegym.model.Music;
import com.codegym.repository.music.IMusicRepository;
import com.codegym.repository.music.MusicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MusicService implements IMusicService{
    @Autowired
    private IMusicRepository musicRepository;

    @Override
    public List<Music> findAll() {
        return musicRepository.findAll();
    }

    @Override
    public Music find(Long id) {
        return musicRepository.find(id);
    }

    @Override
    public void save(Music music) {
        musicRepository.save(music);
    }

    @Override
    public void remove(Long id) {
        musicRepository.remove(id);
    }
}
