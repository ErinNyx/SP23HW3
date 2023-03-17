package com.csc340sp23.bookmanager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookService {

    @Autowired
    private BookRepository repo;

    public List<Book> getAllBooks() {
        return repo.findAll();
    }

    public Book getBookById(long book) {
        return repo.getReferenceById(book);
    }

    public void deleteBookById(long book) {
        repo.deleteById(book);
    }

    public void save(Book book) {
        repo.save(book);
    }
}