package com.example.demo.model.repository;

import com.example.demo.model.bean.Blog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface IBlogRepository extends JpaRepository<Blog, Integer> {
    List<Blog> findByBlogTitleContaining(String title);

    List<Blog> findAllByCatelogyCatelogyId(int id);
}
