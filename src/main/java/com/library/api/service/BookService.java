package com.library.api.service;

import com.library.api.dto.BookDto;
import com.library.api.exception.BookNotFoundException;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public String insertBook(BookDto book){
        bookRepository.save(new Book(book));
        return "OK";
    }

    public String getBookInfo(String title){
        bookRepository.findByTitle(title);
        return "find by title ok";
    }

    public BookDto getBookInfo(Long id){
        return bookRepository.findById(id)
                .map(BookDto::new)
                .orElseThrow(() -> new BookNotFoundException("id: "+id));
    }

}
