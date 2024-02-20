package com.library.api.dto.book.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.api.model.Book;
import com.library.api.model.User;
import com.library.api.model.Waitlist;
import com.library.api.model.enums.BookCondition;
import com.library.api.model.enums.BookGenre;
import jakarta.persistence.*;

public record GetBookInfoResponseDto(

        Long id,

        String author,

        String title,

        @JsonProperty("publication_year")
        int publicationYear,

        BookGenre genre,

        @JsonProperty("book_condition")
        BookCondition bookCondition,

        boolean available,

        //User currentUser,
        @JsonProperty("current_user")
        CurrentUserRespondeDto currentUser,

        Waitlist waitlist
) {
        public GetBookInfoResponseDto(Book book){this(
                book.getId(),
                book.getAuthor(),
                book.getTitle(),
                book.getPublicationYear(),
                book.getGenre(),
                book.getBookCondition(),
                book.isAvailable(),
                book.getCurrentUser() != null ? new CurrentUserRespondeDto(book.getCurrentUser()) : null,
                book.getWaitlist()
        );}
}
