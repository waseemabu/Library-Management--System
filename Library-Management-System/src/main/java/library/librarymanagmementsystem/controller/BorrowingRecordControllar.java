package library.librarymanagmementsystem.controller;

import library.librarymanagmementsystem.models.BorrowingRecord;
import library.librarymanagmementsystem.services.BorrowingRecordServices;
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
@RequestMapping("/api/borrowing-records")
public class BorrowingRecordControllar {

    private final Logger logger = LoggerFactory.getLogger(this.getClass());
    @Autowired
    BorrowingRecordServices borrowingRecordServices;

    @GetMapping("/getAll")
    @Cacheable("allBorrowingRecords")
    public List<BorrowingRecord> getAllBorrowingRecords() {
        logger.info("test");
        return borrowingRecordServices.getAllBorrowingRecords();

    }

    @GetMapping("/{id}")
    public ResponseEntity<BorrowingRecord> getBorrowingRecordById(@PathVariable Long id) {
        Optional<BorrowingRecord> borrowingRecord = borrowingRecordServices.getBorrowingRecordById(id);
        return borrowingRecord.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    @PostMapping("/Add")
    public ResponseEntity<BorrowingRecord> addBorrowingRecord(@RequestBody BorrowingRecord borrowingRecord) {
        BorrowingRecord addedBorrowingRecord = borrowingRecordServices.addBorrowingRecord(borrowingRecord);
        return new ResponseEntity<>(addedBorrowingRecord, HttpStatus.CREATED);
    }

    @PutMapping("/{id}")
    public ResponseEntity<BorrowingRecord> updateBorrowingRecord(@PathVariable Long id, @RequestBody BorrowingRecord borrowingRecord) {
        borrowingRecord.setId(id);
        BorrowingRecord updatedBorrowingRecord = borrowingRecordServices.updateBorrowingRecord(id, borrowingRecord);
        return ResponseEntity.ok(updatedBorrowingRecord);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteBorrowingRecord(@PathVariable Long id) {
        borrowingRecordServices.deleteBorrowingRecord(id);
        return ResponseEntity.noContent().build();
    }
}
