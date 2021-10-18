package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

public class MusicForm {
    private Long id;
    private String name;
    private String singer;
    private Category category;
    private MultipartFile file;

    public MusicForm() {
    }

    public MusicForm(Long id, String name, String singer, Category category, MultipartFile file) {
        this.id = id;
        this.name = name;
        this.singer = singer;
        this.category = category;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSinger() {
        return singer;
    }

    public void setSinger(String singer) {
        this.singer = singer;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public MultipartFile getFile() {
        return file;
    }

    public void setFile(MultipartFile file) {
        this.file = file;
    }
}
