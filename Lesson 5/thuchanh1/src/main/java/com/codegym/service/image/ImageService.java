package com.codegym.service.image;

import com.codegym.model.Image;
import com.codegym.repository.image.IImageRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ImageService implements IImageService{
    @Autowired
    private IImageRepository imageRepository;

    @Override
    public List<Image> findAll() {
        return imageRepository.findAll();
    }

    @Override
    public Image find(Long id) {
        return imageRepository.find(id);
    }

    @Override
    public void save(Image image) {
        imageRepository.save(image);
    }

    @Override
    public void remove(Long id) {
        imageRepository.remove(id);
    }

    @Override
    public List<Image> findAllByCustomerId(Long customer_id) {
        return imageRepository.findAllByCustomerId(customer_id);
    }
}
