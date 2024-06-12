package com.demo.lms.controller;

import com.demo.lms.dto.BookDTO;
import com.demo.lms.handler.ResponseHandler;
import com.demo.lms.service.BookService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @author Sankar Patra
 */
@RestController
@RequestMapping("/v1/books")
public class BookController extends ResponseHandler {

    @Autowired
    private BookService bookService;

    @PostMapping
    public ResponseEntity<?> registerBook(BookDTO bookDTO) {
        return successResponseDataSaving(bookService.registerBook(bookDTO));
    }

    @GetMapping
    public ResponseEntity<?> getAllBooks(@RequestParam int pageNumber,
                                         @RequestParam int pageSize) {
        return successResponseDataRetrieve(bookService.getAllBooks(pageNumber, pageSize));
    }
}
