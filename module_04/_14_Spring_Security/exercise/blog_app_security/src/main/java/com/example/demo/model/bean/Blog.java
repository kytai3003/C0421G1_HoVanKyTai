package com.example.demo.model.bean;

import javax.persistence.*;
import java.sql.Date;

@Entity
@Table
public class Blog {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer blogId;
    private String blogTitle;
    private String blogContent;
    private String blogAuthor;
    private Date createdDate;

    @ManyToOne(targetEntity = Catelogy.class)
    @JoinColumn(name = "catelogy_id", referencedColumnName = "catelogyId")
    private Catelogy catelogy;


    public Blog() {
    }

    public Integer getBlogId() {
        return blogId;
    }

    public void setBlogId(Integer blogId) {
        this.blogId = blogId;
    }

    public String getBlogTitle() {
        return blogTitle;
    }

    public void setBlogTitle(String blogTitle) {
        this.blogTitle = blogTitle;
    }

    public String getBlogContent() {
        return blogContent;
    }

    public void setBlogContent(String blogContent) {
        this.blogContent = blogContent;
    }

    public String getBlogAuthor() {
        return blogAuthor;
    }

    public void setBlogAuthor(String blogAuthor) {
        this.blogAuthor = blogAuthor;
    }

    public Catelogy getCatelogy() {
        return catelogy;
    }

    public void setCatelogy(Catelogy catelogy) {
        this.catelogy = catelogy;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }
}
