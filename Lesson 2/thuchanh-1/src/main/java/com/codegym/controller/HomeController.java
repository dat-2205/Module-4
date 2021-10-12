package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Controller
public class HomeController {
    private static final String EMAIL_REGEX = "^[A-Za-z0-9]+[A-Za-z0-9]*@[A-Za-z0-9]+(\\.[A-Za-z0-9]+)$";
    private static Pattern pattern;
    private Matcher matcher;

    public HomeController() {
        pattern = Pattern.compile(EMAIL_REGEX);
    }

    @GetMapping("")
    public String home() {
        return "index";
    }

    @PostMapping("/validate")
    public ModelAndView checkEmail(@RequestParam("email") String email) {
        ModelAndView modelAndView ;
        boolean isValidate = this.validate(email);
        if(!isValidate) {
            modelAndView = new ModelAndView("index");
            modelAndView.addObject("message","Email is invalid");
            return modelAndView;
        }
        modelAndView = new ModelAndView("success");
        modelAndView.addObject("email", email);
        return modelAndView;
    }

    private boolean validate(String regex) {
        matcher = pattern.matcher(regex);
        return matcher.matches();
    }
}
