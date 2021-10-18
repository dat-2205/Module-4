package com.codegym.controller;


import com.codegym.model.Category;
import com.codegym.model.Music;
import com.codegym.model.MusicForm;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.music.IMusicService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;

@Controller
public class MusicController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IMusicService musicService;

    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    private String home(Model model) {
        List<Music> musicList = musicService.findAll();
        model.addAttribute("musicList",musicList);
        return "index";
    }

    @GetMapping("/create")
    public String showCreate(Model model) {
        List<Category> categoryList = categoryService.findAll();
        MusicForm musicForm = new MusicForm();
        model.addAttribute("musicForm", musicForm);
        model.addAttribute("categoryList",categoryList);
        return  "create";
    }

    @PostMapping("/create")
    public String save(@ModelAttribute MusicForm musicForm, Model model) {
        MultipartFile multipartFile = musicForm.getFile();
        String fileName = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(musicForm.getFile().getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Music music = new Music(musicForm.getId(),musicForm.getName(),musicForm.getSinger(),musicForm.getCategory(),fileName);
        musicService.save(music);
        model.addAttribute("musicForm", musicForm);
        model.addAttribute("message","Created new music!");
        return "create";
    }


}
