package com.codegym.controller;

import com.codegym.model.Product;
import com.codegym.model.ProductForm;
import com.codegym.service.category.ICategoryService;
import com.codegym.service.product.IProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.FileCopyUtils;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;
import java.io.IOException;
import java.util.Optional;


@Controller
public class ProductController {
    @Value("${file-upload}")
    private String fileUpload;
    @Autowired
    private IProductService productService;
    @Autowired
    private ICategoryService categoryService;

    @GetMapping("")
    public String home(Pageable pageable, Model model) {
        Iterable<Product> products = productService.findAll(pageable);
        model.addAttribute("products", products);
        return "index";
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("productForm", new ProductForm());
        model.addAttribute("categories",  categoryService.findAll());
        return "create";
    }

    @PostMapping("/save")
    public String createProduct(@ModelAttribute ProductForm productForm, BindingResult bindingResult) {
        if(bindingResult.hasFieldErrors()) {
            return "create";
        }
        MultipartFile multipartFile = productForm.getImage();
        String fileName = multipartFile.getOriginalFilename();
        try {
            FileCopyUtils.copy(multipartFile.getBytes(), new File(fileUpload + fileName));
        } catch (IOException e) {
            e.printStackTrace();
        }
        Product product = new Product(productForm.getId(), productForm.getName(), productForm.getPrice(),productForm.getDescription(), fileName, productForm.getCategory());
        productService.save(product);
        return "redirect:/";
    }

    @GetMapping("/view/{id}")
    public String showDetailProduct(@PathVariable Long id, Model model) {
        model.addAttribute("product", productService.findById(id).get());
        return "detail";
    }

    @GetMapping("/edit/{id}")
    public String showEditForm(@PathVariable Long id, Model model) {
        Optional<Product> productOptional = productService.findById(id);
        Product product = productOptional.get();
        ProductForm productForm = new ProductForm(product.getId(), product.getName(), product.getPrice(), product.getDescription(), null, product.getCategory());
        model.addAttribute("productForm", productForm);
        model.addAttribute("categories",  categoryService.findAll());
        return "create";
    }

//    @GetMapping("/delete/{id}")
//    public String showConfirmDelete(@PathVariable Long id, Model model) {
//
//    }
}
