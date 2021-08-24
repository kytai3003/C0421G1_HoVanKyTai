package controllers;

import model.Setting;
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
public class SettingController {

    Setting setting = new Setting("English", 50, true, "OK");

    @GetMapping("/status")
    public ModelAndView showStatus() {

        return new ModelAndView("status", "setting", setting);
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        List<String> languages = new ArrayList<>();
        languages.add("English");
        languages.add("Vietnamese");
        languages.add("Japanese");
        languages.add("Chinese");

        List<Integer> pageSize = new ArrayList<>();
        pageSize.add(5);
        pageSize.add(10);
        pageSize.add(15);
        pageSize.add(25);
        pageSize.add(50);
        pageSize.add(100);

        model.addAttribute("languages", languages);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("setting", setting);

        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editSetting(@ModelAttribute("setting") Setting newSetting, RedirectAttributes attributes) {
        setting = newSetting;
        ModelAndView modelAndView = new ModelAndView("edit");
        attributes.addFlashAttribute("message", "Settings have been changed.");
        modelAndView.addObject("newSetting", setting);
        return "redirect:/status";
    }
}
