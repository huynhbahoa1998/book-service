package com.example.bookservice.controlleradvise;

import com.example.bookservice.dto.BookDetailsResponse;
import com.example.bookservice.dto.BookResponse;
import com.example.bookservice.exception.ResourceNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

@RestControllerAdvice
public class ControllerExceptionHandler {

    @ExceptionHandler(ResourceNotFoundException.class)
    @ResponseStatus(HttpStatus.NOT_FOUND)
    public BookDetailsResponse resourceNotFoundException(ResourceNotFoundException exception, WebRequest request) {
        return new BookDetailsResponse(null, exception.getMessage());
    }

    @ExceptionHandler(Exception.class)
    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    public BookResponse globalException(Exception exception, WebRequest request) {
        return new BookResponse(null, exception.getMessage());
    }
}
