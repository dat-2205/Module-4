package com.codegym.controller;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class CalculatorController {
    @GetMapping("")
    public String show() {
        return "index";
    }

    @PostMapping("/change")
    public String change(@RequestParam ("usd") double usd, Model model) {
        double  vnd = usd * 23000;
        model.addAttribute("VND",vnd);
        model.addAttribute("USD",usd);
        return "index";
    }
}
