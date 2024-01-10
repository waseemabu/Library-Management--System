package library.librarymanagmementsystem.services;

import library.librarymanagmementsystem.models.Patron;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface PatronServices {
    List<Patron> getAllPatron();

    @Transactional(rollbackFor = {Exception.class})
    Optional<Patron> findPatronById(Long id);

    Patron createPatron(Patron patron);

    @Transactional(rollbackFor = {Exception.class})
    Patron updatePatron(Patron patron);

    void deletePatron(Long id);
}
