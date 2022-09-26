package com.example.bookservice.dto;

import com.example.bookservice.model.Author;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AuthorResponse {

    private List<Author> authors;

    private String message;
}
