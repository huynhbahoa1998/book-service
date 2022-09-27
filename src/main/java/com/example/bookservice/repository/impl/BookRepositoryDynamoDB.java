package com.example.bookservice.repository.impl;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.example.bookservice.mapper.BookMapper;
import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class BookRepositoryDynamoDB implements BookRepository {

    private final DynamoDB dynamoDB;

    private final Table table;

    private final BookMapper bookMapper;

    @Autowired
    public BookRepositoryDynamoDB(AmazonDynamoDB amazonDynamoDB, BookMapper bookMapper) {
        this.bookMapper = bookMapper;
        dynamoDB = new DynamoDB(amazonDynamoDB);
        table = dynamoDB.getTable(BookRepository.TABLE_NAME);
    }

    public Book create(Book book) {
        table.putItem(bookMapper.mapBookToItem(book));
        return book;
    }

    public Book findById(String uuid) {
        Item item = table.getItem(BookMapper.BOOK_UUID, uuid);
        if (item != null) {
            return bookMapper.mapItemToBook(item);
        } else {
            return null;
        }
    }
}
