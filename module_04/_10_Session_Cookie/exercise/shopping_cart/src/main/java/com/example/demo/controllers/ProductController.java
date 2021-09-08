package com.example.demo.controllers;

import com.example.demo.dto.CartDto;
import com.example.demo.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.service.IProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.util.List;
import java.util.Optional;

@Controller
@SessionAttributes("cart")
@RequestMapping("/shop")
public class ProductController {

    @Autowired
    private IProductService iProductService;

    @ModelAttribute("cart")
    public CartDto initCart() {
        return new CartDto();
    }

    @GetMapping
    public ModelAndView showListPage(@CookieValue(value = "idProduct", defaultValue = "-1") Long idProduct, Model model) {
        System.err.println(idProduct);
        if (idProduct != -1) {
            model.addAttribute("historyProduct", this.iProductService.findById(idProduct).get());
        }
        return new ModelAndView("product/list", "productList", this.iProductService.findAll());
    }

    @GetMapping("/add/{id}")
    public String addToCart(@PathVariable("id") long id, @SessionAttribute("cart") CartDto cart, RedirectAttributes attributes, @RequestParam("action") String action) {
        Optional<Product> productOptional = iProductService.findById(id);

        if (productOptional.isPresent()) {
            ProductDto productDto = new ProductDto();
            BeanUtils.copyProperties(productOptional.get(), productDto);
            if (action.equals("increase")) {
                cart.addProduct(productDto);
                attributes.addFlashAttribute("message", "Product " + productDto.getName() + " have been added to your cart.");
                return "redirect:/cart";
            } else if (action.equals("reduce")) {
                cart.reduceProduct(productDto);
                attributes.addFlashAttribute("message", "Product " + productDto.getName() + " have been removed from your cart.");
                return "redirect:/cart";
            } else {
                attributes.addFlashAttribute("message", "Product " + productDto.getName() + " have been added to your cart.");
                cart.addProduct(productDto);
            }
        }
        return "redirect:/shop";
    }

    @GetMapping("/detail/{id}")
    public ModelAndView showDetail(@PathVariable ("id") long id, HttpServletResponse response) {
        Cookie cookie = new Cookie("idProduct", id + "");
        cookie.setMaxAge(60);
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ModelAndView("product/detail", "product", this.iProductService.findById(id).get());
    }

    @GetMapping("/remove/{id}")
    public String removeProduct(@ModelAttribute("cart") CartDto cart,@PathVariable("id") Long id){
        Product product = this.iProductService.findById(id).get();

        ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        cart.remove(productDto);

        return "redirect:/cart";
    }

}
