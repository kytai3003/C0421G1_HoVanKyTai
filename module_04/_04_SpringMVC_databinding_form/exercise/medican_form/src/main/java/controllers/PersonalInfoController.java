package controllers;

import model.PersonalInformation;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
public class PersonalInfoController {

    PersonalInformation personalInformation = new PersonalInformation();


    @GetMapping("/detail")
    public String detail(Model model) {
       model.addAttribute("personalInformation", personalInformation);
       return "detail";
    }


    @GetMapping("/form")
    public String showForm(Model model) {
        List<String> genderList = new ArrayList<>();
        genderList.add("Male");
        genderList.add("Female");
        genderList.add("Other");

        List<String> nationList = new ArrayList<>();
        nationList.add("Vietnamese");
        nationList.add("Chinese");
        nationList.add("Cambodia");

        model.addAttribute("genderList", genderList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("personalInformation", personalInformation);

        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String editForm(@ModelAttribute("personalInformation") PersonalInformation newPersonalInformation,
                           RedirectAttributes redirectAttributes) {
        personalInformation = newPersonalInformation;
        ModelAndView modelAndView = new ModelAndView();
        redirectAttributes.addFlashAttribute("message", "Success");
        modelAndView.addObject("newPersonalInformation", personalInformation);

        return "redirect:/detail";
    }
}
