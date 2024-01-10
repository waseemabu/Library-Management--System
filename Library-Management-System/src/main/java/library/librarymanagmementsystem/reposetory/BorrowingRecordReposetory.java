package library.librarymanagmementsystem.reposetory;

import library.librarymanagmementsystem.models.BorrowingRecord;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BorrowingRecordReposetory extends JpaRepository<BorrowingRecord, Long> {
}
