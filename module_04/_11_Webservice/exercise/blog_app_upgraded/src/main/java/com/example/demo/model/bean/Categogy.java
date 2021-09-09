package com.example.demo.model.bean;

import com.fasterxml.jackson.annotation.JsonBackReference;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Categogy {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int categogyId;
    private String categogyName;

    @JsonBackReference
    @OneToMany(mappedBy = "categogy", cascade = CascadeType.ALL)
    private Set<Blog> blogs;

    public Categogy() {
    }

    public int getCategogyId() {
        return categogyId;
    }

    public void setCategogyId(int categogyId) {
        this.categogyId = categogyId;
    }

    public String getCategogyName() {
        return categogyName;
    }

    public void setCategogyName(String categogyName) {
        this.categogyName = categogyName;
    }

    public Set<Blog> getBlogs() {
        return blogs;
    }

    public void setBlogs(Set<Blog> blogs) {
        this.blogs = blogs;
    }
}
