package com.library.api.validations;

import com.library.api.dto.BookDto;
import com.library.api.dto.book.request.InsertBookRequestDto;
import org.springframework.stereotype.Component;

public interface BookValidation {

    //return true for valid
    //return false for invalid
    boolean validate(InsertBookRequestDto dto);
}
