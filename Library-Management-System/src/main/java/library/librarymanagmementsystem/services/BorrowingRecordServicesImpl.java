package library.librarymanagmementsystem.services;

import library.librarymanagmementsystem.models.BorrowingRecord;
import library.librarymanagmementsystem.reposetory.BorrowingRecordReposetory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class BorrowingRecordServicesImpl implements BorrowingRecordServices {

    @Autowired
    private BorrowingRecordReposetory borrowingRecordRepository;

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public List<BorrowingRecord> getAllBorrowingRecords() {
        return borrowingRecordRepository.findAll();
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public Optional<BorrowingRecord> getBorrowingRecordById(Long id) {
        return borrowingRecordRepository.findById(id);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public BorrowingRecord addBorrowingRecord(BorrowingRecord borrowingRecord) {
        return borrowingRecordRepository.save(borrowingRecord);
    }

    @Override
    @Transactional(rollbackFor = {Exception.class})
    public BorrowingRecord updateBorrowingRecord(Long id, BorrowingRecord updatedBorrowingRecord) {
        return borrowingRecordRepository.findById(id)
                .map(existingBorrowingRecord -> {
                    existingBorrowingRecord.setReturnDate(updatedBorrowingRecord.getReturnDate());
                    return borrowingRecordRepository.save(existingBorrowingRecord);
                })
                .orElse(null);
    }

    @Override
    public void deleteBorrowingRecord(Long id) {
        borrowingRecordRepository.deleteById(id);
    }


}
