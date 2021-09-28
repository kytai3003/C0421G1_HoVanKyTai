package com.example.demo.controllers;

import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.entity.employee.Employee;
import com.example.demo.model.service.employee.*;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
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
import java.util.Optional;

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
    @Autowired
    private IUserService iUserService;

    @GetMapping(value = {"/list", ""})
    public ModelAndView showList(@PageableDefault(value = 5, sort = "employee_id", direction = Sort.Direction.ASC) Pageable pageable,
                                 @RequestParam Optional<String> employeeName,
                                 @RequestParam Optional<String> positionName) {
        ModelAndView modelAndView = new ModelAndView("employee/list");
        Page<Employee> employees = this.iEmployeeService.findAllByEmployeeNameContainingAndPosition_PositionName(pageable, employeeName.orElse(""), positionName.orElse(""));
        modelAndView.addObject("employeeList", employees);
        modelAndView.addObject("positionList", iPositionService.findAll());
        modelAndView.addObject("employeeName", employeeName.orElse(""));
        modelAndView.addObject("position", positionName.orElse(""));
        if (employees.isEmpty()) {
            modelAndView.addObject("message", "No data");
        }
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("employee/create");
        modelAndView.addObject("divisionList", iDivisionService.findAll());
        modelAndView.addObject("positionList", iPositionService.findAll());
        modelAndView.addObject("educationDegreeList", iEducationService.findAll());
        modelAndView.addObject("userList", iUserService.findAll());
        modelAndView.addObject("employeeDto", new EmployeeDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {

        if (bindingResult.hasFieldErrors()) {
            reloadData(model);
            return "employee/create";
        } else {
            Employee newEmployee = new Employee();
            BeanUtils.copyProperties(employeeDto, newEmployee);
            iEmployeeService.save(newEmployee);
            attributes.addFlashAttribute("message", "New employee created successfully");
            return "redirect:/employee/list";
        }
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Employee employee = iEmployeeService.findById(id).get();
        if (employee == null) {
            return new ModelAndView("403");
        }
        EmployeeDto employeeDto = new EmployeeDto();
        BeanUtils.copyProperties(employee, employeeDto);
        ModelAndView modelAndView = new ModelAndView("employee/edit");
        modelAndView.addObject("employeeDto", employeeDto);
        modelAndView.addObject("divisionList", iDivisionService.findAll());
        modelAndView.addObject("positionList", iPositionService.findAll());
        modelAndView.addObject("educationDegreeList", iEducationService.findAll());
        modelAndView.addObject("userList", iUserService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateEmployee(@ModelAttribute @Validated EmployeeDto employeeDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            reloadData(model);
            return "employee/edit";
        } else {
            Employee updateEmployee = new Employee();
            BeanUtils.copyProperties(employeeDto, updateEmployee);
            iEmployeeService.save(updateEmployee);
            attributes.addFlashAttribute("message", "Employee " + updateEmployee.getEmployeeName() + " updated.");
        }
        return "redirect:/employee/list";
    }

    public void reloadData(Model model) {
        model.addAttribute("divisionList", iDivisionService.findAll());
        model.addAttribute("positionList", iPositionService.findAll());
        model.addAttribute("educationDegreeList", iEducationService.findAll());
        model.addAttribute("userList", iUserService.findAll());
    }

    @PostMapping("/delete")
    public String deleteEmployee(@RequestParam Integer id, RedirectAttributes attributes) {
        iEmployeeService.remove(id);
        attributes.addFlashAttribute("message", "Employee " + id + " removed.");
        return "redirect:/employee/list";
    }

    @GetMapping("/search")
    public ModelAndView searchTitle(@RequestParam("employeeName") String employeeName, @RequestParam("position") Integer position) {
        ModelAndView modelAndView = new ModelAndView("employee/search");
        List<Employee> employees =  null;
        if (employeeName == null) {
            if (position.equals(0)) {
                employees = this.iEmployeeService.findAll();
            } else {
                employees = this.iEmployeeService.findAllByPosition_PositionId(position);
            }
        } else if (position.equals(0)) {
            employees = this.iEmployeeService.findAllByEmployeeNameContaining(employeeName);
        }
//        } else {
//            employees = this.iEmployeeService.findAllByEmployeeNameContainingAndPosition_PositionId(employeeName, position);
//        }
        modelAndView.addObject("employeeList", employees);
        modelAndView.addObject("message", "Found " + employees.size()+ " record(s)");
        return modelAndView;
    }
}
