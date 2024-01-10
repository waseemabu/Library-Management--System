package library.librarymanagmementsystem.controller;

import library.librarymanagmementsystem.models.Book;
import library.librarymanagmementsystem.services.BookServices;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/books")

public class BookController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BookServices bookServices;

    @GetMapping("/getAll")
    @Cacheable("allBooks")
    public List<Book> getAllBooks() {
        logger.info("test");
        return bookServices.getAllBook();

    }

    @GetMapping("/{id}")
    public ResponseEntity<Book> getBookById(@PathVariable Long id) {
        Optional<Book> book = bookServices.findBookById(id);
        logger.info("test");
        return book.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/Add")
    public ResponseEntity<Book> addBook(@RequestBody Book book) {
        Book addedBook = bookServices.createBook(book);
        return new ResponseEntity<>(addedBook, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Book> updateBook(@PathVariable Long id, @RequestBody Book book) {
        book.setId(id);
        Book updatedBook = bookServices.updateBook(book);
        return ResponseEntity.ok(updatedBook);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBook(@PathVariable Long id) {
        bookServices.deleteBook(id);
        return ResponseEntity.noContent().build();
    }


}
