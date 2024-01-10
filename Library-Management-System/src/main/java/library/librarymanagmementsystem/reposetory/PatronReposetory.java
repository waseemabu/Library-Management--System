package library.librarymanagmementsystem.reposetory;

import library.librarymanagmementsystem.models.Patron;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PatronReposetory extends JpaRepository<Patron, Long> {
}
