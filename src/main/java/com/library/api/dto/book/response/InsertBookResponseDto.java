package com.library.api.dto.book.response;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.library.api.dto.book.InsertionStatus;
import com.library.api.dto.book.request.InsertBookRequestDto;
import com.library.api.model.Book;
import com.library.api.model.enums.BookCondition;

public record InsertBookResponseDto (
        @JsonProperty("status")
        InsertionStatus status,

        @JsonProperty("id")
        Long id,

        String author,

        String title,

        @JsonProperty("publication_year")
        int publicationYear,

        @JsonProperty("book_condition")
        BookCondition bookCondition

) {
    public InsertBookResponseDto(Book book){this(InsertionStatus.SUCCESSFULLY_REGISTERED, book.getId(), book.getAuthor(), book.getTitle(), book.getPublicationYear(), book.getBookCondition());};
    public InsertBookResponseDto(InsertBookRequestDto book){this(InsertionStatus.FAILURE_BOOK_ALREADY_REGISTERED, null, book.author(), book.title(), book.publicationYear(), book.bookCondition());};
}
