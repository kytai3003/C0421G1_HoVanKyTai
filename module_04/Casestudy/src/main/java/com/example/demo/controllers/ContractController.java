package com.example.demo.controllers;

import com.example.demo.dto.ContractDetailDto;
import com.example.demo.dto.ContractDto;
import com.example.demo.dto.EmployeeDto;
import com.example.demo.model.entity.contract.Contract;
import com.example.demo.model.entity.contract.ContractDetail;
import com.example.demo.model.entity.employee.Employee;
import com.example.demo.model.service.contract.IAttachServiceService;
import com.example.demo.model.service.contract.IContractDetailService;
import com.example.demo.model.service.contract.IContractService;
import com.example.demo.model.service.customer.ICustomerService;
import com.example.demo.model.service.employee.IEmployeeService;
import com.example.demo.model.service.service.IServiceService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
@RequestMapping("/contract")
public class ContractController {
    @Autowired
    private IContractService iContractService;
    @Autowired
    private IEmployeeService iEmployeeService;
    @Autowired
    private IServiceService iServiceService;
    @Autowired
    private ICustomerService iCustomerService;
    @Autowired
    private IContractDetailService iContractDetailService;
    @Autowired
    private IAttachServiceService iAttachServiceService;

    @GetMapping(value = {"/list", ""})
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("contract/list");
        modelAndView.addObject("contractList", iContractService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("contract/create");
        modelAndView.addObject("customerList", iCustomerService.findAll());
        modelAndView.addObject("employeeList", iEmployeeService.findAll());
        modelAndView.addObject("serviceList", iServiceService.findAll());
        modelAndView.addObject("contractDto", new ContractDto());
        return modelAndView;
    }

    @PostMapping("/save")
    public String saveCustomer(@ModelAttribute @Validated ContractDto contractDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        new ContractDto().validate(contractDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            reloadData(model);
            return "contract/create";
        } else {
            Contract contract = new Contract();
            BeanUtils.copyProperties(contractDto, contract);
            iContractService.save(contract);
            attributes.addFlashAttribute("message", "New contract created successfully");
            return "redirect:/contract/list";
        }
    }

    public void reloadData(Model model) {
        model.addAttribute("customerList", iCustomerService.findAll());
        model.addAttribute("employeeList", iEmployeeService.findAll());
        model.addAttribute("serviceList", iServiceService.findAll());
    }

    public void reloadData2(Model model) {
        model.addAttribute("contractList", iContractService.findAll());
        model.addAttribute("attachServiceList", iAttachServiceService.findAll());
    }

    @GetMapping("/contract-detail/list")
    public ModelAndView showList2(@PageableDefault(value = 5) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("contract/contract-detail-list");
        modelAndView.addObject("contractDetailList", iContractDetailService.findAll(pageable));
        return modelAndView;
    }

    @GetMapping("/contract-detail/create")
    public ModelAndView showCreateForm2() {
        ModelAndView modelAndView = new ModelAndView("contract/contract-detail-create");
        modelAndView.addObject("contractList", iContractService.findAll());
        modelAndView.addObject("attachServiceList", iAttachServiceService.findAll());
        modelAndView.addObject("contractDetailDto", new ContractDetailDto());
        return modelAndView;
    }

    @PostMapping("/contract-detail/save")
    public String saveContractDetail(@ModelAttribute @Validated ContractDetailDto contractDetailDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            reloadData2(model);
            return "contract/contract-detail-create";
        } else {
            ContractDetail contractDetail = new ContractDetail();
            BeanUtils.copyProperties(contractDetailDto, contractDetail);
            iContractDetailService.save(contractDetail);
            attributes.addFlashAttribute("message", "New contract detail created successfully");
            return "redirect:/contract/contract-detail/list";
        }
    }
}
