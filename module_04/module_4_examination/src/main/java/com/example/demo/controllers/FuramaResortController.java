package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaResortController {

    @GetMapping
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/home")
    public String welcomePage() {
        return "index";
    }

    @GetMapping("/index3")
    public String index() {
        return "index3";
    }
}
