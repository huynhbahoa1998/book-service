package com.example.bookservice.controller;

import com.example.bookservice.dto.BookDetailsResponse;
import com.example.bookservice.dto.BookResponse;
import com.example.bookservice.model.Book;
import com.example.bookservice.model.BookDetails;
import com.example.bookservice.service.BookService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping("/book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<BookResponse> create(@RequestBody Book book) {
        try {
            bookService.create(book);
            return ResponseEntity
                    .status(HttpStatus.CREATED)
                    .body(new BookResponse(book, "Created book successfully!"));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BookResponse(null, "Error creating author: " + e.getMessage()));
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<BookDetailsResponse> findById(@PathVariable("id") String uuid) {
        try {
            BookDetails bookDetails = bookService.findById(uuid);
            String message = "";
            if (bookDetails == null) {
                message = "Book with Uuid = " + uuid + " is not exist";
            }
            return ResponseEntity
                    .status(HttpStatus.OK)
                    .body(new BookDetailsResponse(bookDetails, message));
        } catch (Exception e) {
            log.error(e.getMessage());
            return ResponseEntity
                    .status(HttpStatus.INTERNAL_SERVER_ERROR)
                    .body(new BookDetailsResponse(null, "Error getting book: " + e.getMessage()));
        }
    }
}
