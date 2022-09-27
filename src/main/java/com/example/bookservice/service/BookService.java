package com.example.bookservice.service;

import com.example.bookservice.dto.BookDTO;
import com.example.bookservice.dto.BookDetailsDTO;

public interface BookService {

    BookDTO create(BookDTO bookDTO);

    BookDetailsDTO findById(String uuid);
}
