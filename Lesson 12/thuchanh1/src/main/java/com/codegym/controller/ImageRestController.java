package com.codegym.controller;

import com.codegym.model.Image;
import com.codegym.model.ImageForm;
import com.codegym.service.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/images")
@CrossOrigin("*")
public class ImageController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private IImageService imageService;

    @GetMapping
    public ResponseEntity<List<Image>> home() {
        List<Image> imageList = (List<Image>) imageService.findAll();
        if(!imageList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(imageList, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Image> findById(@PathVariable Long id){
        Optional<Image> imageOptional = imageService.findById(id);
        if(!imageOptional.isPresent()) {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
        return new ResponseEntity<>(imageOptional.get(), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Image> saveImage(@RequestParam ImageForm formData) {
        MultipartFile multipartFile = formData.getFile();
        String fileName = multipartFile.getOriginalFilename();

        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Image image = new Image();
        image.setFile(fileName);
        imageService.save(image);
        return new ResponseEntity<>(image,HttpStatus.OK);
    }
}
