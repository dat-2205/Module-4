package com.codegym.model;

import org.springframework.web.multipart.MultipartFile;

import java.util.List;

public class CustomerForm {
    private Long id;
    private String firstName;
    private String lastName;
    private List<MultipartFile> imageList;

    public CustomerForm() {
    }

    public CustomerForm(Long id, String firstName, String lastName, List<MultipartFile> imageList) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.imageList = imageList;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public List<MultipartFile> getImageList() {
        return imageList;
    }

    public void setImageList(List<MultipartFile> imageList) {
        this.imageList = imageList;
    }
}
