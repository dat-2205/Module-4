package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class BlogForm {
    private Long id;
    private String title;
    private String author;
    private String content;
    private Category category;
    private List<MultipartFile> image;

    public BlogForm() {
    }

    public BlogForm(Long id, String title, String author, String content, Category category, List<MultipartFile> image) {
        this.id = id;
        this.title = title;
        this.author = author;
        this.content = content;
        this.category = category;
        this.image = image;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public List<MultipartFile> getImage() {
        return image;
    }

    public void setImage(List<MultipartFile> image) {
        this.image = image;
    }
}
