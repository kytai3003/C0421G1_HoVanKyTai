package com.example.demo.controllers;

import com.example.demo.dto.CustomerDto;
import com.example.demo.dto.ServiceDto;
import com.example.demo.model.entity.service.Service;
import com.example.demo.model.service.service.IRentTypeService;
import com.example.demo.model.service.service.IServiceService;
import com.example.demo.model.service.service.IServiceTypeService;
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
@RequestMapping("/service")
public class ServiceController {

    @Autowired
    private IServiceService iServiceService;
    @Autowired
    private IServiceTypeService iServiceTypeService;
    @Autowired
    private IRentTypeService iRentTypeService;

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 5, sort = "serviceId", direction = Sort.Direction.ASC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("service/list");
        modelAndView.addObject("serviceList", iServiceService.findAll(pageable));
        modelAndView.addObject("serviceTypeList", iServiceTypeService.findAll());
        modelAndView.addObject("rentTypeList", iRentTypeService.findAll());
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("service/create");
        modelAndView.addObject("serviceTypeList", iServiceTypeService.findAll());
        modelAndView.addObject("rentTypeList", iRentTypeService.findAll());
        modelAndView.addObject("serviceDto", new ServiceDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveService(@ModelAttribute @Validated ServiceDto serviceDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {

        if (bindingResult.hasFieldErrors()) {
            reloadData(model);
            return "service/create";
        } else {
            Service newService = new Service();
            BeanUtils.copyProperties(serviceDto, newService);
            iServiceService.save(newService);
            attributes.addFlashAttribute("message", "New service created successfully");
            return "redirect:/service/list";
        }
    }

    @PostMapping("/delete")
    public String deleteService(@RequestParam Integer id, RedirectAttributes attributes) {
        iServiceService.remove(id);
        attributes.addFlashAttribute("message", "Service " + id + " removed.");
        return "redirect:/service/list";
    }

    public void reloadData(Model model) {
        model.addAttribute("serviceTypeList", iServiceTypeService.findAll());
        model.addAttribute("rentTypeList", iRentTypeService.findAll());
    }
}
