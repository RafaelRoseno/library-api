package com.library.api.service;

import com.library.api.dto.book.request.InsertBookRequestDto;
import com.library.api.dto.book.response.GetBookInfoResponseDto;
import com.library.api.dto.book.response.InsertBookResponseDto;
import com.library.api.exception.BookNotFoundException;
import com.library.api.exception.messages.ErrorMessages;
import com.library.api.model.Book;
import com.library.api.repository.BookRepository;
import com.library.api.validations.BookValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private final List<BookValidation> validations;

    @Autowired
    public BookService(BookRepository bookRepository, List<BookValidation> validations){
        this.bookRepository = bookRepository;
        this.validations = validations;
    }

    public List<InsertBookResponseDto> insertBook(List<InsertBookRequestDto> booksRequest) {
        return booksRequest.stream()
                .map(this::bookInsertProcessing)
                .collect(Collectors.toList());
    }

    public List<GetBookInfoResponseDto> getBookInfo() {
        return bookRepository.findAll().stream()
                .map(GetBookInfoResponseDto::new)
                .collect(Collectors.toList());
    }

    public GetBookInfoResponseDto getBookInfoById(Long id) {
        return bookRepository.findById(id)
                .map(GetBookInfoResponseDto::new)
                .orElseThrow(() -> new BookNotFoundException(ErrorMessages.BOOK_NOT_FOUND_BY_ID.build(id)));
    }

    public List<GetBookInfoResponseDto> getBookInfoByTitle(String title) {
        List<GetBookInfoResponseDto> books = bookRepository.findByTitle(title).stream()
                .map(GetBookInfoResponseDto::new)
                .collect(Collectors.toList());

        return validateNotEmpty(books, title);
    }

    private InsertBookResponseDto bookInsertProcessing(InsertBookRequestDto dto) {
        if (validations.stream().allMatch(v -> v.validate(dto))) {
            Book savedBook = bookRepository.save(new Book(dto));
            return new InsertBookResponseDto(savedBook);
        }
        return new InsertBookResponseDto(dto);
    }

    private List<GetBookInfoResponseDto> validateNotEmpty(List<GetBookInfoResponseDto> list, String title) {
        if (list.isEmpty()) {
            throw new BookNotFoundException(ErrorMessages.BOOK_NOT_FOUND_BY_TITLE.build(title));
        }
        return list;
    }


}
