package library.librarymanagmementsystem.services;

import library.librarymanagmementsystem.models.BorrowingRecord;

import java.util.List;
import java.util.Optional;

public interface BorrowingRecordServices {
    List<BorrowingRecord> getAllBorrowingRecords();

    Optional<BorrowingRecord> getBorrowingRecordById(Long id);

    BorrowingRecord addBorrowingRecord(BorrowingRecord borrowingRecord);

    BorrowingRecord updateBorrowingRecord(Long id, BorrowingRecord updatedBorrowingRecord);

    void deleteBorrowingRecord(Long id);
}
