package com.library.api.exception.messages;

public interface ErrorMessage {
    String build(Object... args);
}
