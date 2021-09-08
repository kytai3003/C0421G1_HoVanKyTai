package com.example.demo.controllers;

import com.example.demo.dto.CartDto;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.SessionAttribute;
import org.springframework.web.servlet.ModelAndView;

@Controller
@RequestMapping("/cart")
public class CartController {
    @GetMapping
    public ModelAndView showCart(@SessionAttribute("cart") CartDto cart) {
        return new ModelAndView("cart/list", "cart", cart);
    }
}
