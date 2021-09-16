package com.example.demo.controllers;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Catelogy;
import com.example.demo.model.service.IBlogService;
import com.example.demo.model.service.ICatelogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.sql.Date;
import java.util.List;

@Controller
@RequestMapping("/blog")
public class BlogController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICatelogyService iCatelogyService;

    @GetMapping("/welcome")
    public String welcome() {
        return "welcome";
    }

    @GetMapping("/list")
    public ModelAndView showList(@PageableDefault(value = 5, sort = "createdDate", direction = Sort.Direction.DESC) Pageable pageable) {
        ModelAndView modelAndView = new ModelAndView("blog/list");
        modelAndView.addObject("blogList", iBlogService.findAll(pageable));
        modelAndView.addObject("catelogyList", iCatelogyService.findAll());
        return modelAndView;
    }

    @GetMapping(value = "/list-by-catelogy")
    public String showListByCatelogy(@RequestParam("catelogyId") int catelogyId, Model model) {
        model.addAttribute("blogList", iBlogService.findAllByCatelogyCatelogyId(catelogyId));
        model.addAttribute("catelogyList", iCatelogyService.findAll());
        return "/blog/list-by-catelogy";
    }

    @GetMapping("/create")
    public ModelAndView showCreateForm() {
        ModelAndView modelAndView = new ModelAndView("blog/create");
        List<Catelogy> catelogyList = iCatelogyService.findAll();
        modelAndView.addObject("catelogyList", catelogyList);
        modelAndView.addObject("blog", new Blog());
        return modelAndView;
    }

    @PostMapping("/create")
    public ModelAndView saveCustomer(@ModelAttribute("blog") Blog blog) {
        blog.setCreatedDate(new Date(System.currentTimeMillis()));
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/create");
        modelAndView.addObject("message", "New blog created successfully");
        return modelAndView;
    }

    @GetMapping("/edit/{id}")
    public ModelAndView showEditForm(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/edit")
    public ModelAndView updateCustomer(@ModelAttribute("blog") Blog blog) {
        iBlogService.save(blog);
        ModelAndView modelAndView = new ModelAndView("blog/edit");
        modelAndView.addObject("blog", blog);
        modelAndView.addObject("message", "Blog updated successfully");
        return modelAndView;
    }

    @GetMapping("/read/{id}")
    public ModelAndView readBlog(@PathVariable("id") Integer id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/detail");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @GetMapping("/delete/{id}")
    public ModelAndView showDeleteForm(@PathVariable Integer id) {
        Blog blog = iBlogService.findById(id);
        ModelAndView modelAndView = new ModelAndView("blog/delete");
        modelAndView.addObject("blog", blog);
        return modelAndView;
    }

    @PostMapping("/delete")
    public String deleteCustomer(@ModelAttribute("blog") Blog blog, RedirectAttributes attributes) {
        iBlogService.remove(blog.getBlogId());
        attributes.addFlashAttribute("message", "Removed blog id = " + blog.getBlogId());
        return "redirect:/blog/list";
    }

    @RequestMapping("/search")
    public String searchTitle(@RequestParam("title") String title, Model model) {
        List<Blog> blogs = iBlogService.findByBlogTitleContaining(title);
        model.addAttribute("result", blogs);
        model.addAttribute("message", "Found " + blogs.size()+ " record(s)");
        return "blog/search";
    }

    @GetMapping("/login")
    public String getLoginPage() {
        return "login";
    }
}
