package com.example.demo.model.service;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Catelogy;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    Blog findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    List<Blog> findByBlogTitleContaining(String title);

    List<Blog> findAllByCatelogyCatelogyId(int id);
}
