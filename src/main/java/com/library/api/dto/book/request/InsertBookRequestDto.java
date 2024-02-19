package com.library.api.dto.book.request;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.api.model.Book;
import com.library.api.model.enums.BookCondition;
import com.library.api.model.enums.BookGenre;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record InsertBookRequestDto(
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

        public InsertBookRequestDto(Book book){ this(book.getAuthor(), book.getTitle(), book.getPublicationYear(), book.getGenre(), book.getBookCondition());}
}
