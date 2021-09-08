package com.example.demo.controllers;

import com.example.demo.exception.OutOfNumberException;
import com.example.demo.exception.WrongCodeException;
import com.example.demo.model.entity.Book;
import com.example.demo.model.entity.RentCode;
import com.example.demo.model.service.IBookService;
import com.example.demo.model.service.ICodeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.List;

@Controller
public class BookController {

    @Autowired
    private IBookService iBookService;

    @Autowired
    private ICodeService iCodeService;

    @GetMapping("/list")
    public ModelAndView showList() {
        return new ModelAndView("list", "bookList", this.iBookService.findAll());
    }

    @GetMapping("/rent/{id}")
    public String showCode(@PathVariable("id") int id, Model model) {
        Book book = this.iBookService.findById(id);
        int code = (int) (10000 + (Math.random() * 89999));
        if (book.getAmount() > 0) {
            model.addAttribute("book", book);
            model.addAttribute("code", code);
            return "rent";
        } else {
            return "out-of-number";
        }
    }

    @PostMapping("/rent")
    public String bookRenting(@ModelAttribute("book") Book book, @RequestParam("code") int code, RedirectAttributes attributes) throws OutOfNumberException {
        RentCode codeRent = new RentCode();

        if (book.getAmount() > 0) {

            book.setAmount(book.getAmount() - 1);
            this.iBookService.save(book);

            codeRent.setRentCode(code);
            codeRent.setBook(book);
            this.iCodeService.save(codeRent);
            attributes.addFlashAttribute("message", "Success. Your code is: " + codeRent.getRentCode());
        } else {
            throw new OutOfNumberException();
        }
        return "redirect:/list";
    }

    @GetMapping("/return/{id}")
    public String showReturningPage(@PathVariable("id") int id, Model model) {
        model.addAttribute("book", this.iBookService.findById(id));
        return "return";
    }

    @PostMapping("/return")
    public String bookReturning(@RequestParam("code") int code, @ModelAttribute("book") Book book, RedirectAttributes attributes) throws WrongCodeException {
        boolean isTrueCode = false;
        RentCode rentCode = null;
        List<RentCode> setCode = this.iCodeService.findAll();
        for (RentCode c: setCode) {
            if (c.getRentCode() == code) {
                rentCode = c;
                isTrueCode = true;
                break;
            }
        }

        if (isTrueCode) {

            this.iCodeService.remove(rentCode.getRentCodeId());

            book.setAmount(book.getAmount() + 1);
            this.iBookService.save(book);
            attributes.addFlashAttribute("message", "Success. See you again.");
            return "redirect:/list";
        } else {
//            attributes.addFlashAttribute("message", "Wrong code");
            throw new WrongCodeException();
        }
    }

    @ExceptionHandler(WrongCodeException.class)
    public ModelAndView wrongCodeScreen() {
        return new ModelAndView("wrong-code");
    }

    @ExceptionHandler(OutOfNumberException.class)
    public ModelAndView outOfNumbScreen() {
        return new ModelAndView("out-of-number");
    }
}
