package library.librarymanagmementsystem.reposetory;

import library.librarymanagmementsystem.models.Book;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BookReposetory extends JpaRepository<Book, Long> {
}
