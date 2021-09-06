package com.example.demo.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    private String title;

    private Integer amount;

    @OneToMany(mappedBy = "book")
    private Set<RentCode> rentCode;

    public Book(Integer id, String title, Integer amount, Set<RentCode> rentCode) {
        this.id = id;
        this.title = title;
        this.amount = amount;
        this.rentCode = rentCode;
    }

    public Book() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Integer getAmount() {
        return amount;
    }

    public void setAmount(Integer amount) {
        this.amount = amount;
    }

    public Set<RentCode> getRentCode() {
        return rentCode;
    }

    public void setRentCode(Set<RentCode> rentCode) {
        this.rentCode = rentCode;
    }
}
