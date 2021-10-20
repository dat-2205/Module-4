package com.codegym.model;

import javax.persistence.*;

@Entity
public class Image {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @JoinColumn(name = "blog_id")
    private Blog blog;
    private String file;

    public Image() {
    }

    public Image(Blog blog, String file) {
        this.blog = blog;
        this.file = file;
    }

    public Image(Long id, Blog blog, String file) {
        this.id = id;
        this.blog = blog;
        this.file = file;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Blog getBlog() {
        return blog;
    }

    public void setBlog(Blog blog) {
        this.blog = blog;
    }

    public String getFile() {
        return file;
    }

    public void setFile(String file) {
        this.file = file;
    }
}
