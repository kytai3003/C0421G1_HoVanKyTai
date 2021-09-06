package com.example.demo.model.entity;

import javax.persistence.*;
import java.util.Set;

@Entity
public class RentCode {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int rentCodeId;

    private int rentCode;

    @ManyToOne(targetEntity = Book.class)
    @JoinColumn(name = "book_id", referencedColumnName = "id")
    private Book book;

    public RentCode(int rentCodeId, int rentCode, Book book) {
        this.rentCodeId = rentCodeId;
        this.rentCode = rentCode;
        this.book = book;
    }

    public RentCode() {
    }

    public int getRentCodeId() {
        return rentCodeId;
    }

    public void setRentCodeId(int rentCodeId) {
        this.rentCodeId = rentCodeId;
    }

    public int getRentCode() {
        return rentCode;
    }

    public void setRentCode(int rentCode) {
        this.rentCode = rentCode;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }
}
