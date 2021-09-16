package com.example.demo.model.service.impl;

import com.example.demo.model.bean.Blog;
import com.example.demo.model.bean.Catelogy;
import com.example.demo.model.repository.IBlogRepository;
import com.example.demo.model.service.IBlogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BlogServiceImpl implements IBlogService {

    @Autowired
    private IBlogRepository iBlogRepository;

    @Override
    public Page<Blog> findAll(Pageable pageable) {
        return this.iBlogRepository.findAll(pageable);
    }

    @Override
    public Blog findById(Integer id) {
        return this.iBlogRepository.findById(id).get();
    }

    @Override
    public void save(Blog blog) {
        this.iBlogRepository.save(blog);
    }

    @Override
    public void remove(Integer id) {
        this.iBlogRepository.deleteById(id);
    }

    @Override
    public List<Blog> findByBlogTitleContaining(String title) {
        return this.iBlogRepository.findByBlogTitleContaining(title);
    }

    @Override
    public List<Blog> findAllByCatelogyCatelogyId(int id) {
        return this.iBlogRepository.findAllByCatelogyCatelogyId(id);
    }

}
