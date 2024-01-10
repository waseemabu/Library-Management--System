package library.librarymanagmementsystem.services;

import library.librarymanagmementsystem.models.Patron;
import library.librarymanagmementsystem.reposetory.PatronReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class PatronServicesImpl implements PatronServices {

    @Autowired
    PatronReposetory patronReposetory;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public List<Patron> getAllPatron() {
        return patronReposetory.findAll();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Optional<Patron> findPatronById(Long id) {
        return patronReposetory.findById(id);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Patron createPatron(Patron patron) {
        return patronReposetory.save(patron);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Patron updatePatron(Patron patron) {
        return patronReposetory.save(patron);
    }

    @Override
    public void deletePatron(Long id) {
        patronReposetory.deleteById(id);
    }
}
