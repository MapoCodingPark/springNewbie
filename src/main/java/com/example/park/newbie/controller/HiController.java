package com.example.park.newbie.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HiController {

    @GetMapping("/api/v1/hi")
    public String hi() {
        return "hi world";
    }

}
