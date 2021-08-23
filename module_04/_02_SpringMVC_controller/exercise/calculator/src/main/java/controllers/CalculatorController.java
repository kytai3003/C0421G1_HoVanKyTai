package controllers;


import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @RequestMapping("")
    public String home() {
        return "index";
    }

    @RequestMapping("/calculate")
    public ModelAndView calculate(@RequestParam(required = false) double numb1, double numb2, char operator){
        double result = 0;
        String mess = null;
        switch (operator) {
            case '+':
                result = numb1 + numb2;
                break;
            case '-':
                result = numb1 - numb2;
                break;
            case '*':
                result = numb1 * numb2;
                break;
            case '/':
                if (numb2 == 0) {
                    mess = "Can not divide by 0";
                } else {
                    result = numb1 / numb2;
                }
        }

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("mess", mess);
        modelAndView.addObject("numb1", numb1);
        modelAndView.addObject("numb2", numb2);
        modelAndView.addObject("result", result);

        return modelAndView;
    }
}
