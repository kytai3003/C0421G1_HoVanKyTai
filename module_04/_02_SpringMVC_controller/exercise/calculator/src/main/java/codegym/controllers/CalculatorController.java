package codegym.controllers;


import codegym.model.service.ICalculatorService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CalculatorController {

    @Autowired
    ICalculatorService iCalculatorService;

    @RequestMapping("")
    public String home() {
        return "index";
    }

    @RequestMapping("/calculate")
    public ModelAndView calculate(@RequestParam(required = false) double numb1, double numb2, char operator){

        Double result = null;
        try {
            result = iCalculatorService.calculate(numb1, numb2, operator);
        } catch (NullPointerException e){
            e.printStackTrace();
        }

        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("mess", "Can not divide by 0.");
        modelAndView.addObject("numb1", numb1);
        modelAndView.addObject("numb2", numb2);
        modelAndView.addObject("result", result);

        return modelAndView;
    }
}
