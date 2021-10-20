package com.codegym.service.image;

import com.codegym.model.Blog;
import com.codegym.model.Image;
import com.codegym.service.IGeneralService;

public interface IImageService extends IGeneralService<Image> {
    Iterable<Image> findImageByBlog(Blog blog);
}
