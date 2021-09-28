package com.example.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class FuramaResortController {

    @GetMapping(value = {"", "/login"})
    public String getLoginPage() {
        return "login";
    }

    @GetMapping("/home")
    public String welcomePage() {
        return "index";
    }

    @GetMapping("/403")
    public String accessDenied() {
        return "403";
    }
}
