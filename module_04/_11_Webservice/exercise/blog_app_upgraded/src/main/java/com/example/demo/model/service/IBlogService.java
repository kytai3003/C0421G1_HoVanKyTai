package com.example.demo.model.service;

import com.example.demo.model.bean.Blog;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface IBlogService {
    Page<Blog> findAll(Pageable pageable);

    List<Blog> findAll();

    Optional<Blog> findById(Integer id);

    void save(Blog blog);

    void remove(Integer id);

    List<Blog> findByBlogTitleContaining(String title);

    List<Blog> findAllByCategogyCategogyId(int id);
}
