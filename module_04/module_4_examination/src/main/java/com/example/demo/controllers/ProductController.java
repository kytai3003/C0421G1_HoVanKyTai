package com.example.demo.controllers;

import com.example.demo.dto.ProductDto;
import com.example.demo.model.entity.Product;
import com.example.demo.model.service.IOrderService;
import com.example.demo.model.service.IProductService;
import com.example.demo.model.service.ITypeProductService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private IProductService iProductService;
    @Autowired
    private IOrderService iOrderService;
    @Autowired
    private ITypeProductService iTypeProductService;


    @GetMapping(value = "/list")
    public ModelAndView showList(@PageableDefault(value = 5) Pageable pageable,
                                 @RequestParam(value = "dateFrom", required = false) Date dateFrom,
                                 @RequestParam(value = "dateTo", required = false) Date dateTo) {
        ModelAndView modelAndView = new ModelAndView("product/list");
        Page<Product> productList;
        if (dateFrom == null && dateTo == null) {
            productList = this.iProductService.findAll(pageable);
        } else {
            productList = this.iProductService.findAllByDate(pageable, dateFrom, dateTo);
        }
        modelAndView.addObject("productList", productList);
        modelAndView.addObject("dateFrom", dateFrom);
        modelAndView.addObject("dateTo", dateTo);
        if (productList.isEmpty()) {
            modelAndView.addObject("message", "No data");
        }
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Product product = iProductService.findById(id).get();
         ProductDto productDto = new ProductDto();
        BeanUtils.copyProperties(product, productDto);
        ModelAndView modelAndView = new ModelAndView("product/edit");
        modelAndView.addObject("productDto", productDto);
        modelAndView.addObject("typeProduct", this.iTypeProductService.findAll());
        modelAndView.addObject("orderProduct", this.iOrderService.findAll());
        return modelAndView;
    }

    @PostMapping("/edit")
    public String updateEmployee(@ModelAttribute @Validated ProductDto productDto, BindingResult bindingResult, Model model, RedirectAttributes attributes) {
        if (bindingResult.hasFieldErrors()) {
            return "product/edit";
        } else {
            Product product = new Product();
            BeanUtils.copyProperties(productDto, product);
            iProductService.save(product);
            attributes.addFlashAttribute("message", "Product " + product.getProductName() + " updated.");
        }
        return "redirect:/product/list";
    }
}
