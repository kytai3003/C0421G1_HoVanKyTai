package com.example.demo.controllers;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.entity.customer.Customer;
import com.example.demo.model.entity.customer.CustomerType;
import com.example.demo.model.service.customer.ICustomerService;
import com.example.demo.model.service.customer.ICustomerTypeService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import java.util.List;

@Controller
@RequestMapping("/customer")
public class CustomerController {

    @Autowired
    private ICustomerService iCustomerService;

    @Autowired
    private ICustomerTypeService iCustomerTypeService;

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 5, sort = "customerId", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("customer/list");
        modelAndView.addObject("customerList", iCustomerService.findAll(pageable));
        modelAndView.addObject("customerTypeList", iCustomerTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("customer/create");
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        modelAndView.addObject("customerTypeList", customerTypeList);
        modelAndView.addObject("customerDto", new CustomerDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {

        if (bindingResult.hasFieldErrors()) {
            reloadData(model);
            return "customer/create";
        } else {
            Customer newCustomer = new Customer();
            BeanUtils.copyProperties(customerDto, newCustomer);
            iCustomerService.save(newCustomer);
            attributes.addFlashAttribute("message", "New customer created successfully");
            return "redirect:/customer/list";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Customer customer = iCustomerService.findById(id);
        if (customer == null) {
            return new ModelAndView("error.404");
        }
        CustomerDto customerDto = new CustomerDto();
        BeanUtils.copyProperties(customer, customerDto);
        ModelAndView modelAndView = new ModelAndView("customer/edit");
        modelAndView.addObject("customerDto", customerDto);
        modelAndView.addObject("customerTypeList", iCustomerTypeService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            reloadData(model);
            return "customer/edit";
        } else {
            Customer updateCustomer = new Customer();
            BeanUtils.copyProperties(customerDto, updateCustomer);
            iCustomerService.save(updateCustomer);
            attributes.addFlashAttribute("message", "Customer " + updateCustomer.getCustomerName() + " updated.");
        }
        return "redirect:/customer/list";
    }

    public void reloadData(Model model) {
        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
        model.addAttribute("customerTypeList", customerTypeList);
    }

    @PostMapping("/delete")
    public String deleteCustomer(@RequestParam Integer id, RedirectAttributes attributes) {
        iCustomerService.remove(id);
        attributes.addFlashAttribute("message", "Customer " + id + " removed.");
        return "redirect:/customer/list";
    }

    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public ModelAndView searchTitle(@RequestParam("customerName") String customerName) {
        List<Customer> customerList = iCustomerService.findByCustomerNameIsContaining(customerName);
        ModelAndView modelAndView = new ModelAndView("customer/search");
        if (customerList.isEmpty()) {
            modelAndView.addObject("message", "Customer name " + customerName + " not found.");
        }
        modelAndView.addObject("customerList", customerList);
        modelAndView.addObject("message", "Found " + customerList.size()+ " record(s)");
        return modelAndView;
    }
}
