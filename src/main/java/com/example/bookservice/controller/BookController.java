package com.example.bookservice.controller;

import com.example.bookservice.dto.BookDTO;
import com.example.bookservice.dto.BookDetailsDTO;
import com.example.bookservice.dto.BookDetailsResponse;
import com.example.bookservice.dto.BookResponse;
import com.example.bookservice.exception.ResourceNotFoundException;
import com.example.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/books")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public BookResponse create(@RequestBody BookDTO bookDTO) {
        return new BookResponse(bookService.create(bookDTO), "Created book successfully!");
    }

    @GetMapping("/{id}")
    public BookDetailsResponse findById(@PathVariable("id") String uuid) {
        BookDetailsDTO bookDetailsDTO = bookService.findById(uuid);
        if (bookDetailsDTO != null) {
            return new BookDetailsResponse(bookDetailsDTO, "Got book successfully!");
        } else {
            throw new ResourceNotFoundException("Book with Uuid = " + uuid + " is not exist");
        }
    }
}
