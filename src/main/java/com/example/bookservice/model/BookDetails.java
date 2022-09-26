package com.example.bookservice.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDetails extends Book {

    private String authorFirstName;

    private String authorLastName;

    private String authorEmail;

    private int quantity;

    public BookDetails(Book book, Author author, int quantity) {
        super(book.getUuid(), book.getTitle(), book.getIsbn(), book.getAuthorUuid());
        this.authorFirstName = author.getFirstName();
        this.authorLastName = author.getLastName();
        this.authorEmail = author.getEmail();
        this.quantity = quantity;
    }
}
