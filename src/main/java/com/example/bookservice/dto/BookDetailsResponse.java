package com.example.bookservice.dto;

import com.example.bookservice.model.BookDetails;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class BookDetailsResponse {

    private BookDetails bookDetails;

    private String message;
}
