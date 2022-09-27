package com.example.bookservice.mapper;

import com.amazonaws.services.dynamodbv2.document.Item;
import com.example.bookservice.dto.BookDTO;
import com.example.bookservice.model.Book;
import org.springframework.stereotype.Component;

@Component
public class BookMapper {

    public static final String BOOK_UUID = "Uuid";

    public static final String BOOK_TITLE = "Title";

    public static final String BOOK_ISBN = "Isbn";

    public static final String BOOK_AUTHOR_UUID = "AuthorUuid";

    public Item mapBookToItem(Book book) {
        return new Item()
                .withPrimaryKey(BOOK_UUID, book.getUuid())
                .withString(BOOK_TITLE, book.getTitle())
                .withString(BOOK_ISBN, book.getIsbn())
                .withString(BOOK_AUTHOR_UUID, book.getAuthorUuid());
    }

    public Book mapItemToBook(Item item) {
        return Book.builder()
                .uuid(item.getString(BOOK_UUID))
                .title(item.getString(BOOK_TITLE))
                .isbn(item.getString(BOOK_ISBN))
                .authorUuid(item.getString(BOOK_AUTHOR_UUID))
                .build();
    }

    public BookDTO mapBookToBookDTO(Book book) {
        return BookDTO.builder()
                .uuid(book.getUuid())
                .title(book.getTitle())
                .isbn(book.getIsbn())
                .authorUuid(book.getAuthorUuid())
                .build();
    }

    public Book mapBookDTOToBook(BookDTO bookDTO) {
        return Book.builder()
                .uuid(bookDTO.getUuid())
                .title(bookDTO.getTitle())
                .isbn(bookDTO.getIsbn())
                .authorUuid(bookDTO.getAuthorUuid())
                .build();
    }
}
