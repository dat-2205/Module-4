package com.codegym.repository;

import com.codegym.model.Blog;
import com.codegym.model.Image;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import javax.transaction.Transactional;

@Repository
public interface ImageRepository extends JpaRepository<Image,Long> {
    Iterable<Image> findImageByBlog(Blog blog);
}
