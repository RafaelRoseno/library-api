package com.library.api.validations.book.validations;

import com.library.api.dto.BookDto;
import com.library.api.dto.book.request.InsertBookRequestDto;
import com.library.api.exception.BookAlreadyRegisteredException;
import com.library.api.repository.BookRepository;
import com.library.api.validations.BookValidation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class BookAlreadyRegisteredValidation implements BookValidation {

    @Autowired
    BookRepository bookRepository;

    public boolean validate(InsertBookRequestDto dto) {
        return !bookRepository.existsByAuthorAndTitleAndPublicationYearAndGenre(
                dto.author(),
                dto.title(),
                dto.publicationYear(),
                dto.genre());
    }
}
