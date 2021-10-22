package com.codegym.service.category;

import com.codegym.model.Category;
import com.codegym.service.IGeneralService;
import org.springframework.data.domain.Pageable;

public interface ICategoryService extends IGeneralService<Category> {
    Iterable<Category> findAll();
}
