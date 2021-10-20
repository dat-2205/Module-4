package com.codegym.controller;

import com.codegym.model.Blog;
import com.codegym.model.BlogForm;
import com.codegym.model.Image;
import com.codegym.service.blog.IBlogService;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Optional;

@Controller
public class BlogController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IBlogService blogService;
    @Autowired
    private IImageService imageService;
    @Autowired
    private ICategoryService categoryService;


    @GetMapping("")
    public String home(@PageableDefault(size = 4) Pageable pageable, Model model, @RequestParam(name = "q", required = false) String search) {
        Page<Blog> blogs;
        if(search == null || search.equals("")) {
            blogs = blogService.findAll(pageable);
        }else {
            model.addAttribute("q", search);
            blogs = blogService.findByTitleContaining(search, pageable);
        }
        int pageNum = pageable.getPageNumber();
        model.addAttribute("blogs", blogs);
        model.addAttribute("pageNum", pageNum);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("blogForm", new BlogForm());
        model.addAttribute("categories", categoryService.findAll());
        return "create";
    }

    @PostMapping("/create")
    public String createBlog(@ModelAttribute BlogForm blogForm) {
        List<MultipartFile> multipartFiles = blogForm.getImage();
        Blog blog  = new Blog(blogForm.getId(), blogForm.getTitle(), blogForm.getAuthor(), blogForm.getContent(), blogForm.getCategory());
        blogService.save(blog);
        for(MultipartFile m : multipartFiles) {
            String fileName = m.getOriginalFilename();
            try {
                FileCopyUtils.copy(m.getBytes(), new File(fileUpload + fileName));
            } catch (IOException e) {
                e.printStackTrace();
            }
            imageService.save(new Image(blog, fileName));
        }
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String showDetail(@PathVariable Long id, Model model) {
        Optional<Blog> blogOptional =   blogService.findById(id);
        Blog blog = blogOptional.get();
        Iterable<Image> images = imageService.findImageByBlog(blog);
        model.addAttribute("blog", blog);
        model.addAttribute("images", images);
        return "view";
    }
}
