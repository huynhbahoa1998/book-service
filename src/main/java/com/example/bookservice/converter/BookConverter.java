package com.example.bookservice.converter;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.example.bookservice.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookConverter {

    public final String BOOK_UUID = "Uuid";

    public final String BOOK_TITLE = "Title";

    public final String BOOK_ISBN = "Isbn";

    public final String BOOK_AUTHOR_UUID = "AuthorUuid";

    public Item convertBookToItem(Book book) {
        return new Item()
                .withPrimaryKey(BOOK_UUID, book.getUuid())
                .withString(BOOK_TITLE, book.getTitle())
                .withString(BOOK_ISBN, book.getIsbn())
                .withString(BOOK_AUTHOR_UUID, book.getAuthorUuid());
    }

    public Book convertItemToBook(Item item) {
        Book book = new Book();
        book.setUuid(item.getString(BOOK_UUID));
        book.setTitle(item.getString(BOOK_TITLE));
        book.setIsbn(item.getString(BOOK_ISBN));
        book.setAuthorUuid(item.getString(BOOK_AUTHOR_UUID));
        return book;
    }
}
