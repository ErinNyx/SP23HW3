package com.csc340sp23.bookmanager;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "book")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter

public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id; 
    private String title;
    private String author;
    private String isbn;
    private Double price;

    public Book(String title, String author, String isbn, Double price) {
        this.title = title;
        this.author = author;
        this.isbn = isbn;
        this.price = price;
    }

}