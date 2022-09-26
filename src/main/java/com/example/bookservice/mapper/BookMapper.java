package com.example.bookservice.mapper;

import com.amazonaws.services.dynamodbv2.AmazonDynamoDB;
import com.amazonaws.services.dynamodbv2.document.DynamoDB;
import com.amazonaws.services.dynamodbv2.document.Item;
import com.amazonaws.services.dynamodbv2.document.Table;
import com.example.bookservice.converter.BookConverter;
import com.example.bookservice.model.Book;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    private final String TABLE_NAME = "Book";

    private final DynamoDB dynamoDB;

    private final Table table;

    private final BookConverter bookConverter;

    @Autowired
    public BookMapper(AmazonDynamoDB amazonDynamoDB, BookConverter bookConverter) {
        this.bookConverter = bookConverter;
        dynamoDB = new DynamoDB(amazonDynamoDB);
        table = dynamoDB.getTable(TABLE_NAME);
    }

    public Book create(Book book) {
        table.putItem(bookConverter.convertBookToItem(book));
        return book;
    }

    public Book findById(String uuid) {
        Item item = table.getItem(bookConverter.BOOK_UUID, uuid);
        if (item != null) {
            return bookConverter.convertItemToBook(item);
        } else {
            return null;
        }
    }
}
