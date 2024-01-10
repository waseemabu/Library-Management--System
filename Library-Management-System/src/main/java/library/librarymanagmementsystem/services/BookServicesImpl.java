package library.librarymanagmementsystem.services;

import library.librarymanagmementsystem.models.Book;
import library.librarymanagmementsystem.reposetory.BookReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BookServicesImpl implements BookServices {

    @Autowired
    BookReposetory bookReposetory;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public List<Book> getAllBook() {
        return bookReposetory.findAll();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Optional<Book> findBookById(Long id) {
        return bookReposetory.findById(id);
    }

    @Override
    public void deleteBook(Long id) {
        bookReposetory.deleteById(id);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Book createBook(Book book) {
        return bookReposetory.save(book);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Book updateBook(Book book) {
        return bookReposetory.save(book);
    }
}
