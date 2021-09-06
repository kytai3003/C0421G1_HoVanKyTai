package com.example.demo.controllers;

import com.example.demo.dto.RegisterFormDTO;
import com.example.demo.model.entity.RegisterForm;
import com.example.demo.model.service.IRegisterFormService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.validation.Valid;

@Controller
public class RegisterFormController {

    @Autowired
    private IRegisterFormService iRegisterFormService;

    @GetMapping("/")
    public ModelAndView showForm() {
        return new ModelAndView("create", "registerFormDTO", new RegisterFormDTO());
    }

    @PostMapping("/create")
    public String checkValidation(@Valid @ModelAttribute RegisterFormDTO registerFormDTO, BindingResult bindingResult, Model model) {
        new RegisterFormDTO().validate(registerFormDTO, bindingResult);
        if (bindingResult.hasErrors()) {
//            model.addAttribute("RegisterFormDTO", registerFormDTO);
            return "create";
        } else {
            RegisterForm registerForm = new RegisterForm();
            BeanUtils.copyProperties(registerFormDTO, registerForm);
            iRegisterFormService.save(registerForm);
            return "result";
        }
    }
}
