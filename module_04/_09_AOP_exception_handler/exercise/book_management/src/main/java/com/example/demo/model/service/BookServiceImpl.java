package com.example.demo.model.service;

import com.example.demo.model.entity.Book;
import com.example.demo.model.repo.IBookRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImpl implements IBookService {

    @Autowired
    private IBookRepo iBookRepo;


    @Override
    public List<Book> findAll() {
        return this.iBookRepo.findAll();
    }

    @Override
    public void save(Book book) {
        this.iBookRepo.save(book);
    }

    @Override
    public Book findById(int id) {
        return this.iBookRepo.findById(id).get();
    }

    @Override
    public void remove(int id) {
        this.iBookRepo.deleteById(id);
    }
}
