package com.example.bookservice.service.impl;

import com.example.bookservice.dto.AuthorDTO;
import com.example.bookservice.dto.BookDTO;
import com.example.bookservice.dto.BookDetailsDTO;
import com.example.bookservice.feignclient.AuthorFeignClient;
import com.example.bookservice.mapper.BookMapper;
import com.example.bookservice.model.Book;
import com.example.bookservice.repository.BookRepository;
import com.example.bookservice.repository.InventoryRepository;
import com.example.bookservice.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookMapper bookMapper;

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private InventoryRepository inventoryRepository;

    @Autowired
    private AuthorFeignClient authorFeignClient;

    @Override
    public BookDTO create(BookDTO bookDTO) {
        Book book = bookRepository.create(bookMapper.mapBookDTOToBook(bookDTO));
        return bookMapper.mapBookToBookDTO(book);
    }

    @Override
    public BookDetailsDTO findById(String uuid) {
        Book book = bookRepository.findById(uuid);
        if (book != null) {
            AuthorDTO authorDTO = authorFeignClient.getAuthorById(book.getAuthorUuid()).getBody().getAuthorDTO();
            int quantity = inventoryRepository.getBookQuantity(uuid);
            return new BookDetailsDTO(bookMapper.mapBookToBookDTO(book), authorDTO, quantity);
        }
        return null;
    }
}
