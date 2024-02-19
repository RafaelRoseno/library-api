package com.library.api.service;

import com.library.api.dto.BookDto;
import com.library.api.dto.book.request.InsertBookRequestDto;
import com.library.api.dto.book.response.InsertBookResponseDto;
import com.library.api.exception.BookNotFoundException;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import com.library.api.validations.BookValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class BookService {

    @Autowired
    private BookRepository bookRepository;

    @Autowired
    private List<BookValidation> validations;

    public List<InsertBookResponseDto> insertBook(List<InsertBookRequestDto> booksRequest){
        return booksRequest.stream()
                .map(this::processBook)
                .collect(Collectors.toList());
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

    private InsertBookResponseDto processBook(InsertBookRequestDto dto){
        if(validations.stream().allMatch(v -> v.validate(dto))){
            Book savedBook = bookRepository.save(new Book(dto));
            return new InsertBookResponseDto(savedBook);
        }else {
            return new InsertBookResponseDto(dto);
        }
    }



}
