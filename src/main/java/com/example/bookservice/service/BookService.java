package com.example.bookservice.service;

import com.example.bookservice.model.Book;
import com.example.bookservice.model.BookDetails;

public interface BookService {

    Book create(Book book);

    BookDetails findById(String uuid);
}
