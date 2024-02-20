package com.library.api.controller;

import com.library.api.dto.BookDto;
import com.library.api.dto.book.request.InsertBookRequestDto;
import com.library.api.dto.book.response.GetBookInfoResponseDto;
import com.library.api.dto.book.response.InsertBookResponseDto;
import com.library.api.exception.BookNotFoundException;
import com.library.api.service.BookService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("book")
public class BookController {

    @Autowired
    private BookService bookService;

    @PostMapping
    @Transactional
    public ResponseEntity<List<InsertBookResponseDto>> insertBook(@RequestBody @Valid List<InsertBookRequestDto> dto){
        List<InsertBookResponseDto> books = bookService.insertBook(dto);
        return ResponseEntity.ok(books);
    }

    @GetMapping
    public ResponseEntity<List<GetBookInfoResponseDto>> getBooksInfo(){
        List<GetBookInfoResponseDto> books = bookService.getBookInfo();
        return ResponseEntity.ok(books);
    }

    @GetMapping("/id")
    public ResponseEntity<GetBookInfoResponseDto> getBookInfoById(@RequestParam(required = true) Long id){
        GetBookInfoResponseDto book = bookService.getBookInfoById(id);
        return ResponseEntity.ok(book);
    }

    @GetMapping("/title")
    public ResponseEntity<List<GetBookInfoResponseDto>> getBookInfoByTitle(@RequestParam(required = true) String title){
        List<GetBookInfoResponseDto> books = bookService.getBookInfoByTitle(title);
        return ResponseEntity.ok(books);
    }

}
