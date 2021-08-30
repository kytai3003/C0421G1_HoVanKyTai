package com.example.demo.controllers;

import com.example.demo.model.bean.Customer;
import com.example.demo.model.service.ICustomerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @GetMapping("/list")
    public ModelAndView listCustomers() {
        return new ModelAndView("list", "customerList", iCustomerService.findAll());
    }

    @GetMapping("/create")
    public String showCreateForm(Model model) {
        model.addAttribute("customer", new Customer());
        return "create";
    }

    @PostMapping("/create")
    public String saveCustomer(@ModelAttribute("customer") Customer customer, ModelAndView modelAndView) {
        iCustomerService.insertWithStoredProcedure(customer.getFirstName(), customer.getLastName());
        modelAndView.addObject("customer", new Customer());
        modelAndView.addObject("message", "New customer created successfully");
        return "redirect:/list";
    }
}
