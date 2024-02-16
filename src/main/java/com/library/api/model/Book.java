package com.library.api.model;

import com.library.api.dto.BookDto;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.List;

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

    @Enumerated(EnumType.STRING)
    private BookGenre genre;

    private boolean available;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User currentUser;

    @OneToOne
    private Waitlist waitlist;

    public Book(BookDto dto) {
        this.author = dto.author();
        this.title = dto.title();
        this.genre = dto.genre();
        this.available = true;
    }
}
