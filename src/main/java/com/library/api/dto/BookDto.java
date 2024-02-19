package com.library.api.dto;

import com.library.api.model.Book;
import com.library.api.model.BookGenre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record BookDto(
        Long id,

        @NotBlank
        String author,

        @NotBlank
        String title,

        @NotNull
        BookGenre genre
        ) {

        public BookDto(Book book){ this(book.getId(), book.getAuthor(), book.getTitle(), book.getGenre());}
}
