package com.codegym.controller;

import com.codegym.service.DictionaryService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Locale;

@Controller
public class DictionaryController {
    private static DictionaryService dictionaryService = new DictionaryService();
    @GetMapping("")
    public String showIndex() {
        return "index";
    }

    @PostMapping("dictionary")
    public String translate(@RequestParam ("input") String input, Model model) {
        String result =  dictionaryService.find(input.toLowerCase(Locale.ROOT));
        if(result == null) {
            result = "Not found this word!";
        }
        model.addAttribute("result",result);
        model.addAttribute("input",input);
        return "index";
    }
}
