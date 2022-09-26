package com.example.bookservice.service.impl;

import com.example.bookservice.mapper.BookMapper;
import com.example.bookservice.mapper.InventoryMapper;
import com.example.bookservice.model.Author;
import com.example.bookservice.model.Book;
import com.example.bookservice.model.BookDetails;
import com.example.bookservice.service.AuthorService;
import com.example.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private InventoryMapper inventoryMapper;

    @Autowired
    private AuthorService authorService;

    @Override
    public Book create(Book book) {
        return bookMapper.create(book);
    }

    @Override
    public BookDetails findById(String uuid) {
        Book book = bookMapper.findById(uuid);
        if (book != null) {
            Author author = authorService.getAuthorById(book.getAuthorUuid()).getBody().getAuthors().get(0);
            int quantity = inventoryMapper.getBookQuantity(uuid);
            return new BookDetails(book, author, quantity);
        }
        return null;
    }
}
