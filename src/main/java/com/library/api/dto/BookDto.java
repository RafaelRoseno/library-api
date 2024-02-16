package com.library.api.dto;

import com.library.api.model.BookGenre;
import jakarta.validation.constraints.NotBlank;

public record BookDto(
        Long id,

        @NotBlank
        String author,

        @NotBlank
        String title,

        @NotBlank
        BookGenre genre
        ) {
}
