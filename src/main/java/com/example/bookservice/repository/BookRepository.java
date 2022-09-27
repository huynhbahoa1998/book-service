package com.example.bookservice.repository;

import com.example.bookservice.model.Book;

public interface BookRepository {

    String TABLE_NAME = "Book";

    Book create(Book book);

    Book findById(String uuid);
}
