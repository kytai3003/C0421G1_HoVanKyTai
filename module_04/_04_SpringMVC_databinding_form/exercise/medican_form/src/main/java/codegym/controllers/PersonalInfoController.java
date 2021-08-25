package codegym.controllers;

import codegym.model.bean.PersonalInformation;
import codegym.model.service.InfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class PersonalInfoController {

    @Autowired
    InfoService infoService;

    PersonalInformation personalInformation = new PersonalInformation();

    @GetMapping("/detail")
    public String detail(Model model) {
       model.addAttribute("personalInformation", infoService.edit(personalInformation));
       return "detail";
    }


    @GetMapping("/form")
    public String showForm(Model model) {
        List<String> genderList = infoService.gender();

        List<String> nationList = infoService.nationality();

        model.addAttribute("genderList", genderList);
        model.addAttribute("nationList", nationList);
        model.addAttribute("personalInformation", infoService.edit(personalInformation));

        return "form";
    }

    @RequestMapping(value = "/form", method = RequestMethod.POST)
    public String editForm(@ModelAttribute("personalInformation") PersonalInformation newPersonalInformation,
                           RedirectAttributes redirectAttributes) {
        personalInformation = infoService.edit(newPersonalInformation);
        ModelAndView modelAndView = new ModelAndView();
        redirectAttributes.addFlashAttribute("message", "Success");
        modelAndView.addObject("newPersonalInformation", personalInformation);

        return "redirect:/detail";
    }
}
