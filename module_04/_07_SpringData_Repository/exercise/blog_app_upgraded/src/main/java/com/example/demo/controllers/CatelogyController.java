package com.example.demo.controllers;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Catelogy;
import com.example.demo.model.service.ICatelogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/catelogy")
public class CatelogyController {

    @Autowired
    private ICatelogyService iCatelogyService;

    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ModelAndView showList() {
        return new ModelAndView("catelogy/list", "catelogyList", iCatelogyService.findAll());
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("catelogy/create");
        modelAndView.addObject("catelogy", new Catelogy());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("catelogy") Catelogy catelogy) {
        iCatelogyService.save(catelogy);
        ModelAndView modelAndView = new ModelAndView("catelogy/create");
        modelAndView.addObject("message", "New catelogy created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Catelogy catelogy = iCatelogyService.findById(id);
        ModelAndView modelAndView = new ModelAndView("catelogy/edit");
        modelAndView.addObject("catelogy", catelogy);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("customer") Catelogy catelogy) {
        iCatelogyService.save(catelogy);
        ModelAndView modelAndView = new ModelAndView("catelogy/edit");
        modelAndView.addObject("catelogy", catelogy);
        modelAndView.addObject("message", "Catelogy updated successfully");
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Catelogy catelogy = iCatelogyService.findById(id);
        ModelAndView modelAndView = new ModelAndView("catelogy/delete");
        modelAndView.addObject("catelogy", catelogy);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("customer") Catelogy catelogy, RedirectAttributes attributes) {
        iCatelogyService.remove(catelogy.getCatelogyId());
        attributes.addFlashAttribute("message", "Removed catelogy id = " + catelogy.getCatelogyId());
        return "redirect:/catelogy/list";
    }
}
