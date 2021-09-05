package com.example.demo.controllers;

import com.example.demo.dto.StudentDto;
import com.example.demo.model.entity.Student;
import com.example.demo.model.service.IAccountService;
import com.example.demo.model.service.IBusService;
import com.example.demo.model.service.IStudentService;
import com.example.demo.model.service.ITeacherService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.validation.Valid;
import java.util.Optional;

@Controller
public class StudentController {

    @Autowired
    private IStudentService iStudentService;

    @Autowired
    private ITeacherService iTeacherService;

    @Autowired
    private IBusService iBusService;

    @Autowired
    private IAccountService iAccountService;

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 3) Pageable pageable) {
        return new ModelAndView("list", "studentList", iStudentService.findAll(pageable));
    }

    @GetMapping("/create")
    public String showCreateList(Model model) {
        model.addAttribute("teacherList", iTeacherService.findAll());
        model.addAttribute("busList", iBusService.findAll());
        model.addAttribute("studentDto", new StudentDto());
        return "create";
    }

    private void giveList(Model model) {
        model.addAttribute("teacherList", iTeacherService.findAll());
        model.addAttribute("busList", iBusService.findAll());
    }

    @PostMapping("/create-new")
    public String createNew(@Valid @ModelAttribute("studentDto") StudentDto studentDto, BindingResult bindingResult, RedirectAttributes attributes, Model model){
        new StudentDto().validate(studentDto, bindingResult);
        if (bindingResult.hasFieldErrors()) {
            giveList(model);
            return "/create";
        } else {
            Student student = new Student();
            BeanUtils.copyProperties(studentDto, student);
            iStudentService.save(student);
            attributes.addFlashAttribute("message", "OK!");
            return "redirect:/list";
        }
    }

    @GetMapping("/edit/{id}")
    public String showEditList(@PathVariable("id") int id, Model model) {
        Optional<Student> student = this.iStudentService.findById(id);
        
    }
}
