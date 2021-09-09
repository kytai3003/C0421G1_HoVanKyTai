package com.example.demo.controllers;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Categogy;
import com.example.demo.model.service.IBlogService;
import com.example.demo.model.service.ICategogyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/categogy/api")
public class CategogyRestController {

    @Autowired
    private IBlogService iBlogService;

    @Autowired
    private ICategogyService iCategogyService;

    @GetMapping("/{id}")
    public ResponseEntity<List<Blog>> listByCategogy(@PathVariable int id) {
        List<Blog> blogList = this.iBlogService.findAllByCategogyCategogyId(id);

        if(blogList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }

        return new ResponseEntity<>(blogList, HttpStatus.OK);
    }

    @GetMapping
    public ResponseEntity<List<Categogy>> getCateList() {
        List<Categogy> categogyList = this.iCategogyService.findAll();

        if (categogyList.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(categogyList, HttpStatus.OK);
    }
}
