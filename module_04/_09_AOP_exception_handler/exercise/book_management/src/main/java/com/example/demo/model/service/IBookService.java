package com.example.demo.model.service;

import com.example.demo.model.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> findAll();

    void save(Book book);

    Book findById(int id);

    void remove(int id);
}
