package com.library.api.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.api.model.Book;
import com.library.api.model.enums.BookCondition;
import com.library.api.model.enums.BookGenre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDto(
        Long id,

        @NotBlank
        String author,

        @NotBlank
        String title,

        @NotNull
        @JsonProperty("publication_year")
        int publicationYear,

        @NotNull
        BookGenre genre,

        @NotNull
        @JsonProperty("book_condition")
        BookCondition bookCondition
        ) {

        public BookDto(Book book){ this(book.getId(), book.getAuthor(), book.getTitle(), book.getPublicationYear(), book.getGenre(), book.getBookCondition());}
}
