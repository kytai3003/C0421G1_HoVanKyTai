package com.example.demo.controllers;

import com.example.demo.dto.CustomerDto;
import com.example.demo.model.entity.customer.Customer;
import com.example.demo.model.entity.customer.CustomerType;
import com.example.demo.model.entity.employee.Employee;
import com.example.demo.model.entity.employee.Position;
import com.example.demo.model.service.employee.IDivisionService;
import com.example.demo.model.service.employee.IEducationService;
import com.example.demo.model.service.employee.IEmployeeService;
import com.example.demo.model.service.employee.IPositionService;
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
@RequestMapping("/employee")
public class EmployeeController {

    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IDivisionService iDivisionService;
    @Autowired
    private IPositionService iPositionService;
    @Autowired
    private IEducationService iEducationService;

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 5, sort = "employeeId", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("employee/list");
        modelAndView.addObject("employeeList", iEmployeeService.findAll(pageable));
        modelAndView.addObject("positionList", iPositionService.findAll());
        return modelAndView;
    }

//    @GetMapping("/create")
//    public ModelAndView showCreateForm() {
//        ModelAndView modelAndView = new ModelAndView("customer/create");
//        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
//        modelAndView.addObject("customerTypeList", customerTypeList);
//        modelAndView.addObject("customerDto", new CustomerDto());
//        return modelAndView;
//    }
//
//    @PostMapping("/save")
//    public String saveCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
//
//        if (bindingResult.hasFieldErrors()) {
//            reloadData(model);
//            return "customer/create";
//        } else {
//            Customer newCustomer = new Customer();
//            BeanUtils.copyProperties(customerDto, newCustomer);
//            iCustomerService.save(newCustomer);
//            attributes.addFlashAttribute("message", "New customer created successfully");
//            return "redirect:/customer/list";
//        }
//    }
//
//    @GetMapping("/edit/{id}")
//    public ModelAndView showEditForm(@PathVariable Integer id) {
//        Customer customer = iCustomerService.findById(id);
//        if (customer == null) {
//            return new ModelAndView("error.404");
//        }
//        CustomerDto customerDto = new CustomerDto();
//        BeanUtils.copyProperties(customer, customerDto);
//        ModelAndView modelAndView = new ModelAndView("customer/edit");
//        modelAndView.addObject("customerDto", customerDto);
//        modelAndView.addObject("customerTypeList", iCustomerTypeService.findAll());
//        return modelAndView;
//    }
//
//    @PostMapping("/edit")
//    public String updateCustomer(@ModelAttribute @Validated CustomerDto customerDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
//        if (bindingResult.hasFieldErrors()) {
//            reloadData(model);
//            return "customer/edit";
//        } else {
//            Customer updateCustomer = new Customer();
//            BeanUtils.copyProperties(customerDto, updateCustomer);
//            iCustomerService.save(updateCustomer);
//            attributes.addFlashAttribute("message", "Customer " + updateCustomer.getCustomerName() + " updated.");
//        }
//        return "redirect:/customer/list";
//    }
//
//    public void reloadData(Model model) {
//        List<CustomerType> customerTypeList = iCustomerTypeService.findAll();
//        model.addAttribute("customerTypeList", customerTypeList);
//    }
//
//    @PostMapping("/delete")
//    public String deleteCustomer(@RequestParam Integer id, RedirectAttributes attributes) {
//        iCustomerService.remove(id);
//        attributes.addFlashAttribute("message", "Customer " + id + " removed.");
//        return "redirect:/customer/list";
//    }
//
    @PostMapping("/search")
    public ModelAndView searchTitle(@RequestParam("employeeName") String employeeName, @RequestParam("position") Integer position) {
        ModelAndView modelAndView = new ModelAndView("employee/search");
        List<Employee> employees;
        if (employeeName == null) {
            if (position.equals(0)) {
                employees = this.iEmployeeService.findAll();
            } else {
                employees = this.iEmployeeService.findAllByPosition_PositionId(position);
            }
        } else if (position.equals(0)) {
            employees = this.iEmployeeService.findAllByEmployeeNameContaining(employeeName);
        } else {
            employees = this.iEmployeeService.findAllByEmployeeNameContainingAndPosition_PositionId(employeeName, position);
        }
        modelAndView.addObject("employeeList", employees);
        modelAndView.addObject("message", "Found " + employees.size()+ " record(s)");
        return modelAndView;
    }
}
