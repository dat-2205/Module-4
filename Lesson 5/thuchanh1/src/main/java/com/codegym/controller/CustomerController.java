package com.codegym.controller;

import com.codegym.model.Customer;
import com.codegym.model.Image;
import com.codegym.service.customer.ICustomerService;
import com.codegym.service.image.IImageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {
    @Value("${file-upload}")
    private String fileUpload;

    @Autowired
    private ICustomerService customerService;

    @Autowired
    private IImageService imageService;

    @GetMapping("")
    private String home(Model model) {
        List<Customer> customers = customerService.findAll();
        List<Image> images = imageService.findAll();
        model.addAttribute("customers", customers);
        model.addAttribute("images",images);
        return "customer/index";
    }
}
