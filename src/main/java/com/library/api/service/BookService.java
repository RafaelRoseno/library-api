package com.library.api.service;

import com.library.api.dto.BookDto;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    public String insertBook(BookDto book){
        bookRepository.save(new Book(book));
        return "OK";
    }

}
