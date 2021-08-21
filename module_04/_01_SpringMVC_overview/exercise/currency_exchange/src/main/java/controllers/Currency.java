package controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class Currency {

    @RequestMapping("")
    String home(){
        return "index";
    }

    @GetMapping("/calculate")
    ModelAndView calculate(@RequestParam(name = "rate") Double rate, @RequestParam(name = "amount") Double amount){
        double result = rate * amount;
        ModelAndView modelAndView = new ModelAndView("result");
        modelAndView.addObject("exRate", rate);
        modelAndView.addObject("totalAmount", amount);
        modelAndView.addObject("result",result);
        return modelAndView;
    }

    @GetMapping("")
    String backHome(){
        return "index";
    }

}
