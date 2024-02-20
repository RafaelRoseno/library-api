package com.library.api.dto.book.response;

import com.library.api.model.User;

public record CurrentUserRespondeDto(

        Long id,

        String name
) {

    public CurrentUserRespondeDto(User user){this(
            user.getId(),
            user.getName()
    );}
}
