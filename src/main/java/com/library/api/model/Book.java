package com.library.api.model;

import com.library.api.dto.BookDto;
import com.library.api.dto.book.request.InsertBookRequestDto;
import com.library.api.model.enums.BookCondition;
import com.library.api.model.enums.BookGenre;
import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name = "books")
@Entity(name = "book")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Book {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String author;

    private String title;

    private int publicationYear;

    @Enumerated(EnumType.STRING)
    private BookGenre genre;

    @Enumerated(EnumType.STRING)
    private BookCondition bookCondition;

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User currentUser;

    @OneToOne
    private Waitlist waitlist;

    public Book(InsertBookRequestDto dto) {
        this.author = dto.author();
        this.title = dto.title();
        this.publicationYear = dto.publicationYear();
        this.bookCondition = dto.bookCondition();
        this.genre = dto.genre();
        this.available = true;
    }
}
