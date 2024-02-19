package com.library.api.repository;

import com.library.api.model.Book;
import com.library.api.model.enums.BookGenre;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface BookRepository extends JpaRepository<Book, Long> {

    List<Book> findByTitle(String title);

    boolean existsByAuthorAndTitleAndPublicationYearAndGenre(String author, String title, int publicationYear, BookGenre genre);
}
