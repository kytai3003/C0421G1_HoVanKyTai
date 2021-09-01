package com.example.demo.model.bean;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Catelogy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int catelogyId;
    private String catelogyName;

    @OneToMany(mappedBy = "catelogy", cascade = CascadeType.ALL)
    private Set<Blog> blogs;

    public Catelogy() {
    }

    public int getCatelogyId() {
        return catelogyId;
    }

    public void setCatelogyId(int catelogyId) {
        this.catelogyId = catelogyId;
    }

    public String getCatelogyName() {
        return catelogyName;
    }

    public void setCatelogyName(String catelogyName) {
        this.catelogyName = catelogyName;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
