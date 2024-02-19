package com.library.api.controller;

import com.library.api.dto.BookDto;
import com.library.api.exception.BookNotFoundException;
import com.library.api.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @Transactional
    public ResponseEntity<String> insertBook(@RequestBody @Valid BookDto dto){

        bookService.insertBook(dto);
        return ResponseEntity.ok("success");

    }

    @GetMapping("/id")
    public ResponseEntity<BookDto> getBookInfoById(@RequestParam(required = true) Long id){
        try{
            BookDto book = bookService.getBookInfo(id);
            return ResponseEntity.ok(book);
        }catch (NullPointerException ex){
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/title")
    public ResponseEntity<String> getBookInfoByTitle(@RequestParam(required = true) String title){

        bookService.getBookInfo(title);
        return ResponseEntity.ok("success");
    }

}
