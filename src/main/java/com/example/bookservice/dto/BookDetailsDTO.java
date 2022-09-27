package com.example.bookservice.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailsDTO extends BookDTO {

    private String authorFirstName;

    private String authorLastName;

    private String authorEmail;

    private int quantity;

    public BookDetailsDTO(BookDTO bookDTO, AuthorDTO authorDTO, int quantity) {
        super(bookDTO.getUuid(), bookDTO.getTitle(), bookDTO.getIsbn(), bookDTO.getAuthorUuid());
        this.authorFirstName = authorDTO.getFirstName();
        this.authorLastName = authorDTO.getLastName();
        this.authorEmail = authorDTO.getEmail();
        this.quantity = quantity;
    }
}
