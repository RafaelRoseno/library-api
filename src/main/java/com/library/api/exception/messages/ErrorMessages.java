package com.library.api.exception.messages;

public enum ErrorMessages implements ErrorMessage {

    BOOK_NOT_FOUND_BY_ID("Book not found by ID: %d"),
    BOOK_NOT_FOUND_BY_TITLE("Book not found by TITLE: %s");

    private final String message;

    ErrorMessages(String parameter) {
        this.message = parameter;
    }

    @Override
    public String build(Object... args) {
        return String.format(message, args);
    }
}
