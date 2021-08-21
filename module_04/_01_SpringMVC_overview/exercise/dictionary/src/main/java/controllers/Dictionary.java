package controllers;

import model.service.DictionaryService;
import model.service.DictionaryServiceImpl;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import java.util.Map;

@Controller
public class Dictionary {

    DictionaryService dictionaryService = new DictionaryServiceImpl();
    Map<String, String> dictionary = dictionaryService.searchWord();

    @RequestMapping("")
    String home(){
        return "index";
    }

    @RequestMapping ("/search")
    ModelAndView searchWord(@RequestParam(name = "wordSearch") String wordSearch){

        String wordResult = dictionary.get(wordSearch);

        if (wordResult == null) {
            wordResult = "This word haven't been added yet.";
        }
        ModelAndView modelAndView = new ModelAndView("index");
        modelAndView.addObject("wordResult", wordResult);
        return modelAndView;
    }
}
