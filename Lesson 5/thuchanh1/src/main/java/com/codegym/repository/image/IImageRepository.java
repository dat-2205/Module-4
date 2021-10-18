package com.codegym.repository.image;

import com.codegym.model.Image;
import com.codegym.repository.IGeneralRepository;

import java.util.List;

public interface IImageRepository extends IGeneralRepository<Image> {
    public List<Image> findAllByCustomerId(Long id);
}
