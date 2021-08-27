package codegym.controllers;

import codegym.model.bean.Setting;
import codegym.model.service.ISettingService;
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
public class SettingController {


    @Autowired
    private ISettingService settingService;

    Setting setting = new Setting("English", 50, true, "OK");

    @GetMapping("/status")
    public ModelAndView showStatus() {

        return new ModelAndView("status", "setting", setting);
    }

    @GetMapping("/edit")
    public String showEditForm(Model model) {
        List<String> languages = settingService.languages();

        List<Integer> pageSize = settingService.pageSize();

        model.addAttribute("languages", languages);
        model.addAttribute("pageSize", pageSize);
        model.addAttribute("setting", setting);

        return "edit";
    }

    @RequestMapping(value = "/edit", method = RequestMethod.POST)
    public String editSetting(@ModelAttribute("setting") Setting newSetting, RedirectAttributes attributes) {
        setting = settingService.edit(newSetting);
        ModelAndView modelAndView = new ModelAndView("edit");
        attributes.addFlashAttribute("message", "Settings have been changed.");
        modelAndView.addObject("newSetting", setting);
        return "redirect:/status";
    }
}
