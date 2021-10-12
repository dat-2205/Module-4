package com.codegym.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.TimeZone;

@Controller
public class ClockController {

    @GetMapping("")
    public String home() {
        return "index";
    }

    @GetMapping("world-clock")
    public String showClock(@RequestParam("city") String city, ModelMap modelMap) {
        Date date = new Date();

        TimeZone local = TimeZone.getDefault();

        TimeZone locale = TimeZone.getTimeZone(city);

        long locale_time = date.getTime() + (locale.getRawOffset() - local.getRawOffset());
        date.setTime(locale_time);
        modelMap.addAttribute("city",city);
        modelMap.addAttribute("date",date);
        return "index";
    }
}
