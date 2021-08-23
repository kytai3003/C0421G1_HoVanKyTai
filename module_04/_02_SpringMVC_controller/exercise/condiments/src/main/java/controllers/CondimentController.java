package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class CondimentController {

    @RequestMapping("")
    public String home() {
        return "index";
    }

    @RequestMapping("/save")
    public ModelAndView save(@RequestParam(value = ("condiment"), required = false) String[] condiment) {
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("mess", "Nothing");
        modelAndView.addObject("condiments", condiment);
        return modelAndView;
    }
}
