package library.librarymanagmementsystem.controller;

import library.librarymanagmementsystem.models.Patron;
import library.librarymanagmementsystem.services.PatronServices;
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
@RequestMapping("/api/patrons")
public class PatronController {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    private PatronServices patronServices;

    @GetMapping("/getAll")
    @Cacheable(value = "allPatrons", key = "'allPatrons'")
    public List<Patron> getAllPatrons() {
        logger.info("test");
        return patronServices.getAllPatron();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Patron> getPatronById(@PathVariable Long id) {
        Optional<Patron> patron = patronServices.findPatronById(id);
        return patron.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/Add")
    public ResponseEntity<Patron> createPatron(@RequestBody Patron patron) {
        Patron createdPatron = patronServices.createPatron(patron);
        return new ResponseEntity<>(createdPatron, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Patron> updatePatron(@PathVariable Long id, @RequestBody Patron patron) {
        patron.setId(id);
        Patron updatedPatron = patronServices.updatePatron(patron);
        return ResponseEntity.ok(updatedPatron);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePatron(@PathVariable Long id) {
        patronServices.deletePatron(id);
        return ResponseEntity.noContent().build();
    }
}
