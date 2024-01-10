package library.librarymanagmementsystem.services;

import library.librarymanagmementsystem.models.Book;

import java.util.List;
import java.util.Optional;

public interface BookServices {
    List<Book> getAllBook();

    Optional<Book> findBookById(Long id);

    void deleteBook(Long id);

    Book createBook(Book book);

    Book updateBook(Book book);
}
