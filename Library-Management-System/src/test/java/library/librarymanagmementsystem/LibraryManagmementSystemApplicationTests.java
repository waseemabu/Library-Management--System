package library.librarymanagmementsystem;

import library.librarymanagmementsystem.controller.BookController;
import library.librarymanagmementsystem.controller.PatronController;
import library.librarymanagmementsystem.models.Book;
import library.librarymanagmementsystem.models.Patron;
import library.librarymanagmementsystem.reposetory.BookReposetory;
import library.librarymanagmementsystem.reposetory.BorrowingRecordReposetory;
import library.librarymanagmementsystem.reposetory.PatronReposetory;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@SpringBootTest
@RunWith(SpringRunner.class)
@Rollback(false)
class LibraryManagmementSystemApplicationTests {


    @Autowired
    BookReposetory bookReposetory;

    @Autowired
    PatronReposetory patronReposetory;

    @Autowired
    BorrowingRecordReposetory borrowingRecordReposetory;

    @Autowired
    BookController bookController;
    @Autowired
    private PatronController patronController;

    //test Add book
    @Test
    void AddBook() {
        Book book = new Book();

        book.setAuthor("tester2");
        book.setTitle("test2");
        book.setISPN("3333");
        book.setPublicationYear("3/1/2024");

        bookController.addBook(book);
    }

    @Test
    void findBookById() {
        Long id = 2L;

        Optional<Book> book = bookReposetory.findById(id);

    }

    @Test
    void deleteBook() {
        Long id = 1L;
        bookReposetory.deleteById(id);
    }


    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    void testUpdateBook() {

        Long bookIdToUpdate = 2L;
        Optional<Book> optionalBook = bookReposetory.findById(bookIdToUpdate);


        optionalBook.ifPresent(book -> {
            book.setTitle("Update");
            bookReposetory.save(book);
        });

    }

    @Test
    void AddPatron() {
        Patron patron = new Patron();

        patron.setName("tester3");
        patron.setAddress("tessst");
        patron.setPhone("9999999999999");

        patronReposetory.save(patron);
    }

    @Test
    void findPatronById() {
        Long id = 1L;

        Optional<Patron> patron = patronReposetory.findById(id);

    }

    @Test
    void deletePatron() {
        Long id = 1L;
        patronReposetory.deleteById(id);
    }

    ///////////////////////////////////////////////////////////////////////////////////////////////////////////////

    ////test the caching

    @Test
    void testUpdatePatron() {

        Long patronIdToUpdate = 2L;
        Optional<Patron> optionalPatron = patronReposetory.findById(patronIdToUpdate);


        optionalPatron.ifPresent(patron -> {
            patron.setAddress("Update");
            patronReposetory.save(patron);
        });
    }

    @Test
    public void testCaching() {

        patronController.getAllPatrons();
        patronController.getAllPatrons();
        patronController.getAllPatrons();
    }
}
